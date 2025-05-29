/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleJamCode2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author gollum1er
 */
public class Permutation {

    private String chemin = "C:\\Users\\gollum1er\\Desktop\\";

    public Integer moveNDigits(Integer nb, Integer nbDigitsToMove) {
        String strNb = nb.toString();
        String res = strNb.substring(strNb.length() - nbDigitsToMove, strNb.length()) + strNb.substring(0, strNb.length() - nbDigitsToMove);
        return Integer.parseInt(res);
    }

    public List<Integer> findAllPermutationsWithDigits(Integer nb, Integer nbDigitsToMove, Integer min, Integer max) {
        List<Integer> resListTmp = new ArrayList<Integer>();
        Integer tmpRes = this.moveNDigits(nb, nbDigitsToMove);
        if (tmpRes > nb && tmpRes >= min && tmpRes <= max) {
            resListTmp.add(tmpRes);
        }
        Set set = new HashSet();
        set.addAll(resListTmp);
        ArrayList resList = new ArrayList(set);
        return resList;
    }

    public List<Integer> findAllPermutations(Integer nb, Integer min, Integer max) {
        String strNb = nb.toString();
        List<Integer> resListTmp = new ArrayList<Integer>();
        for (int i = 1; i < strNb.length(); i++) {
            List<Integer> resListTmp2 = this.findAllPermutationsWithDigits(nb, i, min, max);
            resListTmp.addAll(resListTmp2);
        }
        Set set = new HashSet();
        set.addAll(resListTmp);
        ArrayList resList = new ArrayList(set);
        return resList;
    }

    public Integer findRes(int min, int max) {
        Integer res = 0;
        for (int i = min; i < max + 1; i++) {
            List<Integer> tmpList = this.findAllPermutations(i, min, max);
            res += tmpList.size();
        }
        return res;
    }
    
    //lecture pour le fichier de recherche
    public List readFile(String nFichier) {
        List<String> res = new ArrayList<String>();
        String nomFichier = chemin + nFichier;
        try {
            BufferedReader in = new BufferedReader(new FileReader(nomFichier));
            String line =in.readLine();
            while ((line = in.readLine()) != null) {
                res.add(line);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //écrit le résultat des trie
    public void writeFile(List content, String nFichier) {
        String nomFichier = chemin + nFichier;
        try {
            PrintWriter out = new PrintWriter(new FileWriter(nomFichier));
            Iterator it = content.iterator();
            int cpt = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                out.println("Case #" + cpt + ": " +str);
                cpt++;
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Permutation pm = new Permutation();
        List inputList = pm.readFile("C-small-attempt0.in");
        Iterator it = inputList.iterator();
        List resList = new ArrayList<String>();
        while (it.hasNext()) {
            String resTmp = (String)it.next();
            String str[] = resTmp.split(" ");
            Integer res = pm.findRes(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            resList.add(Integer.toString(res));
        }
        pm.writeFile(resList, "toto.txt");
    }
}
