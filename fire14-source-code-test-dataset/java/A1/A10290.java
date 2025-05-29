package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

import protocols.ConfigurableStreamHandlerFactory;

public class QuestionHandler {

	static {
		ConfigurableStreamHandlerFactory.Init();
	}

	private final ISolver solver;

	private String newLine = System.getProperty("line.separator");

	public QuestionHandler(ISolver solver) {
		this.solver = solver;
	}

	public void addCase(String problem, String answer) {
		solver.addCase(problem, answer);
	}

	public void addResource(String problemResource, String answerResource) {
		try {
			addResource(new URL(autoCompleteResourceName(problemResource)),
					new URL(autoCompleteResourceName(answerResource)));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public void addResource(URL problemUrl, URL answerUrl) {
		try {
			BufferedReader problemReader = new BufferedReader(
					new InputStreamReader(problemUrl.openStream()));
			BufferedReader answerReader = new BufferedReader(
					new InputStreamReader(answerUrl.openStream()));

			int numberOfCases = Integer.valueOf(problemReader.readLine());
			for (int i = 0; i < numberOfCases; ++i) {
				String answerLine = answerReader.readLine();
				answerLine = answerLine.substring(answerLine.indexOf(':') + 2);
				solver.addCase(problemReader.readLine(), answerLine);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void solve(String problemResource, String answerResource) {
		try {
			solve(new URL(autoCompleteResourceName(problemResource)), new URL(
					autoCompleteResourceName(answerResource)));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public void solve(URL problemUrl, URL answerUrl) {
		try {
			String path = answerUrl.getPath().replace('\\', '/');
			String curDir = System.getProperty("user.dir").replace('\\', '/')
					+ "/";
			File outFile = new File(curDir + "src/" + path);
			solve(problemUrl, new FileWriter(outFile), new OutputStreamWriter(
					System.out) {
				@Override
				public void close() throws IOException {
					
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void solve(URL problemUrl, Writer... writers) {
		try {
			BufferedReader problemReader = new BufferedReader(
					new InputStreamReader(problemUrl.openStream()));

			int numberOfCases = Integer.valueOf(problemReader.readLine());
			for (int i = 0; i < numberOfCases; ++i) {
				String solution = "Case #" + (i + 1) + ": "
						+ solver.solve(problemReader.readLine());
				for (Writer writer : writers) {
					writer.write(solution);
					writer.write(newLine);
				}
			}
			for (Writer writer : writers) {
				writer.flush();
				writer.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public <T extends ISolver> T getSolver() {
		return (T)solver;
	}

	private String autoCompleteResourceName(String resource) {
		if (resource.indexOf(":") != -1) {
			return resource;
		}
		return "classpath:"
				+ solver.getClass().getPackage().getName().replace('.', '/')
				+ "/" + resource;
	}

}
