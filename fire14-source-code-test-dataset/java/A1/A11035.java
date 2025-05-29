package fixjava;

import java.awt.Adjustable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class ZoomPanel extends JPanel {

	public static abstract class ZoomContent extends JPanel {
		// Width and height of canvas contents, in canvas coordinates
		private float contentWCanv, contentHCanv;

		// Width and height of canvas contents, in screen coordinates
		private int contentWScr, contentHScr;

		// Canvas scroll position, in screen coordinates
		private int contentXScr, contentYScr;

		// Current zoom
		protected float scale = 1.0f;

		// Initialize zoom etc. the first time canvas is painted
		private boolean firstPaint = true;

		// The scrollbar components in the parent ZoomPanel
		private JScrollBar hScrollBar;
		private JScrollBar vScrollBar;

		// ---------------------------------------------------------------------------------------------------

		public ZoomContent(float contentWidth, float contentHeight) {
			this.contentWCanv = contentWidth;
			this.contentHCanv = contentHeight;
			final ZoomContent canvas = this;
			final float[] mouseXY = new float[2];

			this.addMouseWheelListener(new MouseWheelListener() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {
					canvas.mouseWheelMoved(e);
				}
			});
			this.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
					canvas.mouseMoved(e, toCanvasCoords(e, mouseXY));
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					canvas.mouseDragged(e, toCanvasCoords(e, mouseXY));
				}
			});
			this.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					canvas.mouseReleased(e, toCanvasCoords(e, mouseXY));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					canvas.mousePressed(e, toCanvasCoords(e, mouseXY));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					canvas.mouseExited(e, toCanvasCoords(e, mouseXY));
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					canvas.mouseEntered(e, toCanvasCoords(e, mouseXY));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					canvas.mouseClicked(e, toCanvasCoords(e, mouseXY));
				}
			});
		}

		// ---------------------------------------------------------------------------------------------------

		/** Called first time paint() is called, to set up zoom etc. */
		private void zoomToFit() {
			int w = getWidth(), h = getHeight();

			// Scale to fit
			scale = Math.min(w / (float) contentWCanv, h / (float) contentHCanv);

			// Center in window
			zoomBy(1.0, 0, 0);
		}

		private void resized() {
			// Center in window if needed
			zoomBy(1.0, 0, 0);
		}

		// ---------------------------------------------------------------------------------------------------

		/** Called by ZoomPanel after setting up scrollbars */
		protected void addScrollBars(final JScrollBar hScrollBar, final JScrollBar vScrollBar) {
			this.hScrollBar = hScrollBar;
			this.vScrollBar = vScrollBar;

			hScrollBar.addAdjustmentListener(new AdjustmentListener() {
				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					int hMax = hScrollBar.getMaximum();
					float hScale = hMax == 0 ? 0.0f : 1.0f / hMax;
					scrollToX((hScrollBar.getValue() + hScrollBar.getVisibleAmount() / 2) * hScale);
				}
			});
			vScrollBar.addAdjustmentListener(new AdjustmentListener() {
				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					int vMax = vScrollBar.getMaximum();
					float vScale = vMax == 0 ? 0.0f : 1.0f / vMax;
					scrollToY((vScrollBar.getValue() + vScrollBar.getVisibleAmount() / 2) * vScale);
				}
			});
		}

		// ---------------------------------------------------------------------------------------------------

		// Override these methods as needed in subclasses. canvasXY is the x/y canvas coords of the mouse point. 

		public void mouseMoved(MouseEvent e, float[] canvasXY) {
		}

		public void mouseDragged(MouseEvent e, float[] canvasXY) {
		}

		public void mouseClicked(MouseEvent e, float[] canvasXY) {
		}

		public void mousePressed(MouseEvent e, float[] canvasXY) {
		}

		public void mouseReleased(MouseEvent e, float[] canvasXY) {
		}

		public void mouseEntered(MouseEvent e, float[] canvasXY) {
		}

		public void mouseExited(MouseEvent e, float[] canvasXY) {
		}

		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() == '1')
				zoomToFit();
		}

		public void mouseWheelMoved(MouseWheelEvent e) {
			double scrollAmt = e.getPreciseWheelRotation();
			zoomBy(Math.pow(e.isControlDown() ? 1.2 : 1.05, -scrollAmt), e.getX(), e.getY());
		}

		// ------------------------------------------------------------------------------------------------

		protected void scrollToX(float scrollbarFracX) {
			int viewportWScr = getWidth();
			contentXScr = (int) (viewportWScr / 2 - contentWScr * scrollbarFracX);
			repaint();
		}

		protected void scrollToY(float scrollbarFracY) {
			int viewportHScr = getHeight();
			contentYScr = (int) (viewportHScr / 2 - contentHScr * scrollbarFracY);
			repaint();
		}

		// ------------------------------------------------------------------------------------------------

		protected void zoomBy(double zoomFactor, int centerXScr, int centerYScr) {
			// Change scale
			scale *= zoomFactor;

			// Update size of contents in screen coordinates
			contentWScr = (int) Math.ceil(contentWCanv * scale);
			contentHScr = (int) Math.ceil(contentHCanv * scale);

			// Update scroll position in screen coordinates
			contentXScr = (int) Math.round((contentXScr - centerXScr) * zoomFactor + centerXScr);
			contentYScr = (int) Math.round((contentYScr - centerYScr) * zoomFactor + centerYScr);

			// Figure out size and position of scrollbars
			if (hScrollBar != null && vScrollBar != null) {
				int viewportWScr = getWidth(), viewportHScr = getHeight();

				// Snap view to beginning or end of scroll region if we zoom off the end 
				int viewPosX = -contentXScr, viewPosMaxX = contentWScr - viewportWScr;
				viewPosX = Math.max(Math.min(viewPosX, viewPosMaxX), 0);
				int viewPosY = -contentYScr, viewPosMaxY = contentHScr - viewportHScr;
				viewPosY = Math.max(Math.min(viewPosY, viewPosMaxY), 0);

				if (viewPosMaxX > 0) {
					// Canvas wider than viewport
					hScrollBar.setMaximum(contentWScr);
					hScrollBar.setValue(viewPosX);
					hScrollBar.setVisibleAmount(viewportWScr);
					hScrollBar.setBlockIncrement((int) Math.ceil(viewportWScr * 0.8f));
					hScrollBar.setUnitIncrement((int) Math.ceil(viewportWScr * 0.08f));
					hScrollBar.setEnabled(true);
				} else {
					// Canvas narrower than viewport, center it horizontally
					hScrollBar.setEnabled(false);
					contentXScr = (viewportWScr - contentWScr) / 2;
				}
				if (viewPosMaxY > 0) {
					// Canvas taller than viewport
					vScrollBar.setMaximum(contentHScr);
					vScrollBar.setValue(viewPosY);
					vScrollBar.setVisibleAmount(viewportHScr);
					vScrollBar.setBlockIncrement((int) Math.ceil(viewportHScr * 0.8f));
					vScrollBar.setUnitIncrement((int) Math.ceil(viewportHScr * 0.08f));
					vScrollBar.setEnabled(true);
				} else {
					// Canvas shorter than viewport, center it vertically
					vScrollBar.setEnabled(false);
					contentYScr = (viewportHScr - contentHScr) / 2;
				}
			}

			repaint();
		}

		// ------------------------------------------------------------------------------------------------

		protected float[] toCanvasCoords(int screenX, int screenY, float[] outXY) {
			outXY[0] = (screenX - contentXScr) / scale;
			outXY[1] = (screenY - contentYScr) / scale;
			return outXY;
		}

		protected float[] toCanvasCoords(int screenX, int screenY) {
			float[] outXY = new float[2];
			toCanvasCoords(screenX, screenY, outXY);
			return outXY;
		}

		protected float[] toCanvasCoords(MouseEvent e) {
			return toCanvasCoords(e.getX(), e.getY());
		}

		protected float[] toCanvasCoords(MouseEvent e, float[] outXY) {
			toCanvasCoords(e.getX(), e.getY(), outXY);
			return outXY;
		}

		// ------------------------------------------------------------------------------------------------

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;

			if (firstPaint) {
				zoomToFit();
				firstPaint = false;
			}

			g2.drawRect(contentXScr, contentYScr, contentWScr, contentHScr);

			AffineTransform orig = g2.getTransform();

			// Correctly center scaled canvas in viewport
			g2.translate(contentXScr, contentYScr);
			g2.scale(scale, scale);

			// Run user-provided code
			paintCanvas(g2);

			// Restore old transform
			g2.setTransform(orig);
		}

		/** Override this to draw your content */
		public abstract void paintCanvas(Graphics2D g);
	}

	// ------------------------------------------------------------------------------------------------

	/** A zoomable image */
	public static class ZoomImageContent extends ZoomContent {
		protected BufferedImage img;

		public ZoomImageContent(BufferedImage img) {
			super(img.getWidth(), img.getHeight());
			this.img = img;
		}

		@Override
		public void paintCanvas(Graphics2D g) {
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(img, 0, 0, null);
		}
	}

	// ------------------------------------------------------------------------------------------------

	public ZoomPanel(final ZoomContent content) {
		// Set up layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// Add content panel
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		this.add(content, gridBagConstraints);

		JScrollBar hScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		//hScrollBar.addAdjustmentListener(scrollBarListener);
		this.add(hScrollBar, gridBagConstraints);

		JScrollBar vScrollBar = new JScrollBar(Adjustable.VERTICAL);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		//vScrollBar.addAdjustmentListener(scrollBarListener);
		this.add(vScrollBar, gridBagConstraints);

		// Create small spacer panel in corner between scrollbars
		JPanel cornerPanel = new JPanel();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 0.0;
		gridBagConstraints.weighty = 0.0;
		this.add(cornerPanel, gridBagConstraints);

		// Add scrollbar refs to ZoomContent
		content.addScrollBars(hScrollBar, vScrollBar);

		// Update scrollbar block increments when window size changes
		content.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				content.resized();
			}
		});
	}

	// ------------------------------------------------------------------------------------------------

	/** Create new ZoomFrame. Calls System.exit(0) on window close. */
	public static class ZoomFrame extends JFrame {
		protected ZoomContent content;

		@SuppressWarnings("unused")
		private ZoomFrame() {
		}

		public ZoomFrame(String title, int windowWidth, int windowHeight, final ZoomContent content) {
			// Set window title
			super(title);

			// Keep ref to content in case subclasses need it
			this.content = content;
			
			// Exit on window close
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});

			// Catch keystrokes
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					content.keyTyped(e);
				}
			});

			this.setSize(windowWidth, windowHeight);

			// Add ZoomPanel to ZoomFrame, and add ZoomContent to ZoomPanel
			this.add(new ZoomPanel(content));

			this.setVisible(true);
		}
	}

	// ------------------------------------------------------------------------------------------------

	// Demo usage
	public static void main(String[] args) {
		new ZoomFrame("Zoom Panel", 1024, 768, new ZoomContent(800, 600) {
			int x = 100, y = 100;

			@Override
			public void paintCanvas(Graphics2D g) {
				g.fillOval(x, y, 50, 50);
			}

			@Override
			public void mousePressed(MouseEvent e, float[] coords) {
				x = (int) coords[0] - 25;
				y = (int) coords[1] - 25;
				repaint();
			}
		});
	}
}
