/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leider.ken;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 *
 * @author ken
 */
interface Parser {

    Map<Integer, Callable<String>> parse(String fileName) throws IOException;
}
