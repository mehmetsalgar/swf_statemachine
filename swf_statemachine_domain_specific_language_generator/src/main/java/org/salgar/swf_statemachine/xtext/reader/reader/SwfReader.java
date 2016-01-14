package org.salgar.swf_statemachine.xtext.reader.reader;

import org.apache.log4j.Logger;
import org.eclipse.xtext.mwe.Reader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by salgar on 1/4/16.
 */
public class SwfReader extends Reader {
    private static final Logger LOGGER = Logger.getLogger(SwfReader.class);

    @Override
    public void setUseJavaClassPath(boolean isUse) {
        if (isUse) {
            Set<String> classPathEntries = new HashSet();
            retrieveClassPathEntries(Thread.currentThread().getContextClassLoader(), classPathEntries);
            List<String> tmp = new ArrayList<>(classPathEntries);

            for (String entry : tmp) {
                addPath(entry);
            }

        }
    }

    private Set<String> retrieveClassPathEntries(ClassLoader classLoader, Set<String> classPathEntries) {
        List<String> givenLoaderClassPathEntries = new ArrayList<String>();
        if (classLoader instanceof URLClassLoader) {
            URLClassLoader tmp = (URLClassLoader) classLoader;
            for(URL classPathURL : tmp.getURLs()) {
                String classPath = classPathURL.getPath().trim().toLowerCase();

                if (classPath.endsWith("/") || classPath.endsWith(".jar")) {
                    givenLoaderClassPathEntries.add(classPathURL.getFile());
                }
            }
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("Classpath entries from thread context loader: {" + givenLoaderClassPathEntries.toString() + "}");
            }
            classPathEntries.addAll(givenLoaderClassPathEntries);
        }
        if (givenLoaderClassPathEntries.isEmpty() && (classLoader instanceof URLClassLoader || classLoader == null)) {
            givenLoaderClassPathEntries.addAll(retrieveSystemClassPathEntries());
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug("System classpath entries from thread context loader: {" + givenLoaderClassPathEntries.toString() + "}");
            }
            classPathEntries.addAll(givenLoaderClassPathEntries);
            return classPathEntries;
        }
        if( classLoader.getParent() != null) {
            retrieveClassPathEntries(classLoader.getParent(), classPathEntries);
        }
        return classPathEntries;
    }

    private static List<String> retrieveSystemClassPathEntries() {
        List<String> pathes = new ArrayList<>();
        String classPath = System.getProperty("java.class.path");
        String separator = System.getProperty("path.separator");
        String[] strings = classPath.split(separator);

        for(String path : strings) {
            pathes.add(path);
        }

        return pathes;
    }
}
