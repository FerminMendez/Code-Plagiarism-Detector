package com.brootdev.gcj2012.problemD;

import com.brootdev.gcj2012.common.Data;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());
    private static final double PI2 = Math.PI * 2;

    private static final double maxError = .001;

    private Data data;
    private long casesNumber;
    private long currentCase;

    private int H;
    private int W;
    private int D;

    private double errPerDist;
    private int raysNumber;
    private double currErr;

    private double userX;
    private double userY;
    private int userTileX;
    private int userTileY;
    private TileType[][] tiles;

    private double velX;
    private double velY;
    private int tileX;
    private int tileY;
    private double localX;
    private double localY;
    private double dist;

    private double newLocalX;
    private double newLocalY;
    private double distDelta;
    private LocalMoveStatus localMoveStatus;

    private int currentRay;
    private long userHits;
    private boolean userHitLast;
    private boolean firstRayHit;

    static {
        logger.setLevel(Level.FINEST);
    }

    public static void main(String[] args) throws IOException {
        new Main().go(args[0], args[1]);
    }

    public void go(String inFile, String outFile) throws IOException {
        data = new Data(inFile, outFile);
        casesNumber = data.readLongLine();
        for (currentCase = 0; currentCase < casesNumber; currentCase++) {
            data.writeCaseHeader(currentCase);
            processCase();
        }

        data.out.flush();
    }

    private void processCase() throws IOException {
        readMap();
        castRays();
    }

    private void readMap() throws IOException {
        int[] ints = data.readIntsArrayLine();
        H = ints[0];
        W = ints[1];
        D = ints[2];

        tiles = new TileType[H][W];
        errPerDist = maxError / D;
        raysNumber = (int) (2 * Math.PI / Math.asin(errPerDist));

        logger.info(String.format("case=%d, raysNumber=%d", currentCase, raysNumber));
        for (int y = 0; y < H; y++) {
            char[] row = data.in.readLine().toCharArray();
            for (int x = 0; x < W; x++) {
                char c = row[x];
                switch (c) {
                    case 'X':
                        tiles[y][x] = TileType.USER;
                        userTileX = x;
                        userTileY = y;
                        userX = x + .5;
                        userY = y + .5;
                        break;
                    case '#':
                        tiles[y][x] = TileType.MIRROR;
                        break;
                    case '.':
                        tiles[y][x] = TileType.EMPTY;
                        break;
                    default:
                        throw new RuntimeException("Invalid tile: " + c);
                }
            }
        }
    }

    private void castRays() {
        userHits = 0;
        userHitLast = false;
        firstRayHit = false;
        for (currentRay = 0; currentRay < raysNumber; currentRay++) {
            double angle = Math.PI * 2 * currentRay / raysNumber;
            velX = Math.sin(angle);
            velY = Math.cos(angle);
            tileX = userTileX;
            tileY = userTileY;
            localX = userX % 1;
            localY = userY % 1;
            dist = 0;
//            logger.info(String.format("Casting ray %d/%d: velX=%f, velY=%f", ray, raysNumber, velX, velY));

            while (true) {
                currErr = (dist + 1.5) * errPerDist;

                if (checkUserHit()) {
                    break;
                }
                performLocalMove();

                dist += distDelta;
                if (dist > D || performTileMove()) {
                    userHitLast = false;
                    break;
                }

//                logger.info(String.format("posX=%f, posY=%f, velX=%f, velY=%f, dist=%f",
//                        localX + tileX, localY + tileY, velX, velY, dist));
            }
        }

        if (firstRayHit && userHitLast) {
            userHits--;
        }

        data.out.println(userHits);
    }

    private void performLocalMove() {
        if (velX > 0) {
            distDelta = (1 - localX) / velX;
            newLocalY = localY + velY * distDelta;
            if (newLocalY >= 0 && newLocalY <= 1) {
                newLocalX = 1;
                if (velY > 0 && newLocalY >= 1 - currErr) {
                    newLocalY = 1;
                    localMoveStatus = LocalMoveStatus.BOTTOMRIGHT;
                } else if (velY < 0 && newLocalY <= currErr) {
                    newLocalY = 0;
                    localMoveStatus = LocalMoveStatus.TOPRIGHT;
                } else {
                    localMoveStatus = LocalMoveStatus.RIGHT;
                }
                return;
            }
        }
        if (velX < 0) {
            distDelta = - localX / velX;
            newLocalY = localY + velY * distDelta;
            if (newLocalY >= 0 && newLocalY <= 1) {
                newLocalX = 0;
                if (velY > 0 && newLocalY >= 1 - currErr) {
                    newLocalY = 1;
                    localMoveStatus = LocalMoveStatus.BOTTOMLEFT;
                } else if (velY < 0 && newLocalY <= currErr) {
                    newLocalY = 0;
                    localMoveStatus = LocalMoveStatus.TOPLEFT;
                } else {
                    localMoveStatus = LocalMoveStatus.LEFT;
                }
                return;
            }
        }
        if (velY > 0) {
            distDelta = (1 - localY) / velY;
            newLocalY = 1;
            newLocalX = localX + velX * distDelta;
            if (velX > 0 && newLocalX >= 1 - currErr) {
                newLocalX = 1;
                localMoveStatus = LocalMoveStatus.BOTTOMRIGHT;
            } else if (velX < 0 && newLocalX <= currErr) {
                newLocalX = 0;
                localMoveStatus = LocalMoveStatus.BOTTOMLEFT;
            } else {
                localMoveStatus = LocalMoveStatus.BOTTOM;
            }
            return;
        }
        if (velY < 0) {
            distDelta = - localY / velY;
            newLocalY = 0;
            newLocalX = localX + velX * distDelta;
            if (velX > 0 && newLocalX >= 1 - currErr) {
                newLocalX = 1;
                localMoveStatus = LocalMoveStatus.TOPRIGHT;
            } else if (velX < 0 && newLocalX <= currErr) {
                newLocalX = 0;
                localMoveStatus = LocalMoveStatus.TOPLEFT;
            } else {
                localMoveStatus = LocalMoveStatus.TOP;
            }
            return;
        }
    }

    private boolean checkUserHit() {
        if (dist == 0 || tileX != userTileX || tileY != userTileY) {
            return false;
        }

        final double avalDist = D - dist + currErr;
        if (Math.abs(velX) <= currErr) {
            if (avalDist >= .5 && Math.abs(.5 - localX) <= currErr) {
                doUserHit();
                return true;
            }
            return false;
        }
        if (Math.abs(velY) <= currErr) {
            if (avalDist >= .5 && Math.abs(.5 - localY) <= currErr) {
                doUserHit();
                return true;
            }
            return false;
        }

        if (avalDist < Math.sqrt(Math.pow(localX - .5, 2) + Math.pow(localY - .5, 2))) {
            return false;
        }

        final double a = velY / velX;
        final double b = localY - a * localX;

        if (Math.abs(a * .5 + b - .5) <= currErr || Math.abs((.5 - b) / a - .5) <= currErr) {
            doUserHit();
            return true;
        }

//        final double w = velY / velX;
//        final double A = 1.0 / (w * localY - localX);
//        final double B = - w * A;
//        final double d = Math.abs((A + B) * .5 + 1) / Math.sqrt(A * A + B * B);

//        if (d <= sensDist) {
//            doUserHit();
//            return true;
//        }

        return false;
    }

    private void doUserHit() {
        if (! userHitLast) {
            userHits++;
            if (currentRay == 0) {
                firstRayHit = true;
            }

//            logger.info(String.format("Hit! case=%d, ray=%d", currentCase, currentRay));
        }
        userHitLast = true;
    }

    private boolean performTileMove() {
        localX = newLocalX;
        localY = newLocalY;

        switch (localMoveStatus) {
            case TOPLEFT:
                if (tiles[tileY - 1][tileX - 1] != TileType.MIRROR) {
                    tileX--;
                    tileY--;
                    localX = 1;
                    localY = 1;
                    return false;
                } else if (tiles[tileY - 1][tileX] != TileType.MIRROR && tiles[tileY][tileX - 1] != TileType.MIRROR) {
                    return true;
                }
                break;
            case TOPRIGHT:
                if (tiles[tileY - 1][tileX + 1] != TileType.MIRROR) {
                    tileX++;
                    tileY--;
                    localX = 0;
                    localY = 1;
                    return false;
                } else if (tiles[tileY - 1][tileX] != TileType.MIRROR && tiles[tileY][tileX + 1] != TileType.MIRROR) {
                    return true;
                }
                break;
            case BOTTOMLEFT:
                if (tiles[tileY + 1][tileX - 1] != TileType.MIRROR) {
                    tileX--;
                    tileY++;
                    localX = 1;
                    localY = 0;
                    return false;
                } else if (tiles[tileY + 1][tileX] != TileType.MIRROR && tiles[tileY][tileX - 1] != TileType.MIRROR) {
                    return true;
                }
                break;
            case BOTTOMRIGHT:
                if (tiles[tileY + 1][tileX + 1] != TileType.MIRROR) {
                    tileX++;
                    tileY++;
                    localX = 0;
                    localY = 0;
                    return false;
                } else if (tiles[tileY + 1][tileX] != TileType.MIRROR && tiles[tileY][tileX + 1] != TileType.MIRROR) {
                    return true;
                }
                break;
        }

        if (localMoveStatus.isTop) {
            if (tiles[tileY - 1][tileX] == TileType.MIRROR) {
                velY = -velY;
            } else {
                tileY--;
                localY = 1;
            }
        }
        if (localMoveStatus.isBottom) {
            if (tiles[tileY + 1][tileX] == TileType.MIRROR) {
                velY = -velY;
            } else {
                tileY++;
                localY = 0;
            }
        }
        if (localMoveStatus.isLeft) {
            if (tiles[tileY][tileX - 1] == TileType.MIRROR) {
                velX = -velX;
            } else {
                tileX--;
                localX = 1;
            }
        }
        if (localMoveStatus.isRight) {
            if (tiles[tileY][tileX + 1] == TileType.MIRROR) {
                velX = -velX;
            } else {
                tileX++;
                localX = 0;
            }
        }

        return false;
    }

    private enum TileType {
        EMPTY, MIRROR, USER
    }

    private enum LocalMoveStatus {
        TOP(true, false, false, false),
        BOTTOM(false, true, false, false),
        LEFT(false, false, true, false),
        RIGHT(false, false, false, true),
        TOPLEFT(true, false, true, false),
        TOPRIGHT(true, false, false, true),
        BOTTOMLEFT(false, true, true, false),
        BOTTOMRIGHT(false, true, false, true);

        public final boolean isTop;
        public final boolean isBottom;
        public final boolean isLeft;
        public final boolean isRight;

        private LocalMoveStatus(boolean top, boolean bottom, boolean left, boolean right) {
            isTop = top;
            isBottom = bottom;
            isLeft = left;
            isRight = right;
        }
    }
}
