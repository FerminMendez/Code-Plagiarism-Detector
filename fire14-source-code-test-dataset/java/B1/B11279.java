package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Utils {
    static final String outputFileName = "D:\\output.txt";
    static ArrayList<String> outputData = new ArrayList<String>();
    
    public static void run(Class<?> cls){
        Object obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        outputData.clear();

        String[] args = Utils.readInput(cls);
        Method method = getMethod(obj.getClass());
        executeMethod(obj, args, method);
        writeToFile();
    }

    private static void executeMethod(Object obj, String[] args, Method method) {
        int index = 0;
        int n = Integer.valueOf(args[index++]);
        if (n == args.length - 1){
            for(int i = 0; i < n; i++){
                Class<?>[] t = method.getParameterTypes();
                Object[] par = new Object[t.length];
                for (int j = 0; j < t.length; j++) {
                    par[j] = parseParameter(args[index++], t[j]);
                }
                try {
                    printOutput(i+1, method.invoke(obj, par));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            for(int i = 0; i < n; i++){
                Class<?>[] t = method.getParameterTypes();
                Object[] par = new Object[t.length];

                String[] sp = args[index++].split(" ");
                if(t.length == sp.length){
                    for (int j = 0; j < t.length; j++) {
                        String[] sArr = new String[Integer.valueOf(sp[j])];
                        for (int k = 0; k < sArr.length; k++) {
                            sArr[k] = args[index++];
                        }
                        par[j] = sArr;
                    }
                }
                try {
                    printOutput(i+1, method.invoke(obj, par));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    private static String[] readInput(Class<?> cls){
        String fileName = cls.getSimpleName() + ".in";
        BufferedReader in = new BufferedReader(new InputStreamReader(cls.getResourceAsStream(fileName)));
        ArrayList<String> res = new ArrayList<String>();

        String s;
        try {
            while((s = in.readLine()) != null){
                res.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toArray(new String[]{});
    }

    private static Method getMethod(Class<?> cls){
        Method[] methods = null;
        try {
            methods = cls.getDeclaredMethods();
            for(Method m : methods)
                if(Modifier.isPublic(m.getModifiers())) return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object parseParameter(String arg, Class<?> cls) {
        if(cls == int.class){
            return Integer.valueOf(arg);
        }else if(cls == int[].class){
            String[] split = arg.split(" ");
            int[] res = new int[split.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = Integer.valueOf(split[i]);
            }
            return res;
        }else if(cls == long[].class){
            String[] split = arg.split(" ");
            long[] res = new long[split.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = Long.valueOf(split[i]);
            }
            return res;
        }else if(cls == String.class){
            return arg;
        }
        return null;
    }

    private static void printOutput(int count, Object res) {
        Class<?> cls = res.getClass();
        String data = "Case #" + count + ": ";
        if(cls == int[].class){
            int[] array = (int[]) res;
            for (int i = 0; i < array.length; i++) {
                data += array[i] + " ";
            }
            data = data.substring(0, data.length() - 1);
        }else{
            data += res;
        }
        System.out.println(data);
        outputData.add(data);
    }


    private static void writeToFile() {
        try {
            FileWriter fstream = new FileWriter(outputFileName);
            BufferedWriter out = new BufferedWriter(fstream);
            for(String s : outputData){
                out.write(s);
                out.newLine();
            }
            out.close();
            fstream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}