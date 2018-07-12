package com.xhwl.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenerator {

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MybatisGenerator.class.getResourceAsStream("/generator/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
//    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration configuration = cp.parseConfiguration(MybatisGenerator.class.getResourceAsStream("/generator/generatorConfig.xml"));
//        DefaultShellCallback shellCallback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, shellCallback, warnings);
//        //myBatisGenerator.generate(null);
//        
//        MybatisGenerator.generate(configuration,shellCallback,warnings,null, null, null);
//       
//    }
//    
//    public static void generate(Configuration configuration,DefaultShellCallback shellCallback,List<String> warnings,
//    		ProgressCallback callback, Set<String> contextIds,
//            Set<String> fullyQualifiedTableNames) throws SQLException,
//            IOException, InterruptedException {
//
//        if (callback == null) {
//            callback = new NullProgressCallback();
//        }
//
//        List<GeneratedJavaFile> generatedJavaFiles = new ArrayList<GeneratedJavaFile>();
//
//        List<GeneratedXmlFile> generatedXmlFiles = new ArrayList<GeneratedXmlFile>();
//        
//        Set<String> projects  = new HashSet<String>();
//
//        // calculate the contexts to run
//        List<Context> contextsToRun;
//        if (contextIds == null || contextIds.size() == 0) {
//            contextsToRun = configuration.getContexts();
//        } else {
//            contextsToRun = new ArrayList<Context>();
//            for (Context context : configuration.getContexts()) {
//                if (contextIds.contains(context.getId())) {
//                    contextsToRun.add(context);
//                }
//            }
//        }
//
//        // setup custom classloader if required
//        if (configuration.getClassPathEntries().size() > 0) {
//            ClassLoader classLoader = getCustomClassloader(configuration.getClassPathEntries());
//            ObjectFactory.addExternalClassLoader(classLoader);
//        }
//
//        // now run the introspections...
//        int totalSteps = 0;
//        for (Context context : contextsToRun) {
//            totalSteps += context.getIntrospectionSteps();
//        }
//        callback.introspectionStarted(totalSteps);
//
//        for (Context context : contextsToRun) {
//            context.introspectTables(callback, warnings,
//                    fullyQualifiedTableNames);
//        }
//
//        // now run the generates
//        totalSteps = 0;
//        for (Context context : contextsToRun) {
//            totalSteps += context.getGenerationSteps();
//        }
//        callback.generationStarted(totalSteps);
//
//        for (Context context : contextsToRun) {
//        	context.generateFiles(callback, generatedJavaFiles,
//                    generatedXmlFiles, warnings);
//        }
//
//        // now save the files
//        callback.saveStarted(generatedXmlFiles.size()
//                + generatedJavaFiles.size());
//
//        boolean isMergeable = false;
//        for (Context context : contextsToRun) {
//        	String tmp = context.getProperty("mergeable");
//        	if(StringUtils.isNotBlank(tmp)){
//        		isMergeable = Boolean.parseBoolean(tmp);
//        	}
//        }
//        System.out.println("isMergeable:" + isMergeable);
//        //System.out.println("generatedXmlFiles.size():" + generatedXmlFiles.size());
//        
//        for (GeneratedXmlFile gxf : generatedXmlFiles) {
//        	projects.add(gxf.getTargetProject());
//
//            File targetFile;
//            String source;
//            try {
//                File directory = shellCallback.getDirectory(gxf
//                        .getTargetProject(), gxf.getTargetPackage());
//                targetFile = new File(directory, gxf.getFileName());
//                if (targetFile.exists()) {
//                    if (isMergeable) {
//                	    source = XmlFileMergerJaxp.getMergedSource(gxf,
//                                targetFile);
//                    } else 
//                    if (shellCallback.isOverwriteEnabled()) {
//                        source = gxf.getFormattedContent();
//                        warnings.add(getString("Warning.11", //$NON-NLS-1$
//                                targetFile.getAbsolutePath()));
//                    } else {
//                        source = gxf.getFormattedContent();
//                        targetFile = getUniqueFileName(directory, gxf
//                                .getFileName());
//                        warnings.add(getString(
//                                "Warning.2", targetFile.getAbsolutePath())); //$NON-NLS-1$
//                    }
//                } else {
//                    source = gxf.getFormattedContent();
//                }
//            } catch (ShellException e) {
//                warnings.add(e.getMessage());
//                continue;
//            }
//
//            callback.checkCancel();
//            callback.startTask(getString(
//                    "Progress.15", targetFile.getName())); //$NON-NLS-1$
//            writeFile(targetFile, source, "UTF-8"); //$NON-NLS-1$
//        }
//
//        for (GeneratedJavaFile gjf : generatedJavaFiles) {
//            projects.add(gjf.getTargetProject());
//
//            File targetFile;
//            String source;
//            try {
//                File directory = shellCallback.getDirectory(gjf
//                        .getTargetProject(), gjf.getTargetPackage());
//                targetFile = new File(directory, gjf.getFileName());
//                if (targetFile.exists()) {
//                    if (shellCallback.isMergeSupported()) {
//                        source = shellCallback.mergeJavaFile(gjf
//                                .getFormattedContent(), targetFile
//                                .getAbsolutePath(),
//                                MergeConstants.OLD_ELEMENT_TAGS,
//                                gjf.getFileEncoding());
//                    } else if (shellCallback.isOverwriteEnabled()) {
//                        source = gjf.getFormattedContent();
//                        warnings.add(getString("Warning.11", //$NON-NLS-1$
//                                targetFile.getAbsolutePath()));
//                    } else {
//                        source = gjf.getFormattedContent();
//                        targetFile = getUniqueFileName(directory, gjf
//                                .getFileName());
//                        warnings.add(getString(
//                                "Warning.2", targetFile.getAbsolutePath())); //$NON-NLS-1$
//                    }
//                } else {
//                    source = gjf.getFormattedContent();
//                }
//
//                callback.checkCancel();
//                callback.startTask(getString(
//                        "Progress.15", targetFile.getName())); //$NON-NLS-1$
//                writeFile(targetFile, source, gjf.getFileEncoding());
//            } catch (ShellException e) {
//                warnings.add(e.getMessage());
//            }
//        }
//
//        for (String project : projects) {
//            shellCallback.refreshProject(project);
//        }
//
//        callback.done();
//    }
//    
//    public static void writeFile(File file, String content, String fileEncoding) throws IOException {
//        FileOutputStream fos = new FileOutputStream(file, false);
//        OutputStreamWriter osw;
//        if (fileEncoding == null) {
//            osw = new OutputStreamWriter(fos);
//        } else {
//            osw = new OutputStreamWriter(fos, fileEncoding);
//        }
//        
//        BufferedWriter bw = new BufferedWriter(osw);
//        bw.write(content);
//        bw.close();
//    }
//    
//    public static File getUniqueFileName(File directory, String fileName) {
//        File answer = null;
//
//        // try up to 1000 times to generate a unique file name
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < 1000; i++) {
//            sb.setLength(0);
//            sb.append(fileName);
//            sb.append('.');
//            sb.append(i);
//
//            File testFile = new File(directory, sb.toString());
//            if (!testFile.exists()) {
//                answer = testFile;
//                break;
//            }
//        }
//
//        if (answer == null) {
//            throw new RuntimeException(getString(
//                    "RuntimeError.3", directory.getAbsolutePath())); //$NON-NLS-1$
//        }
//
//        return answer;
//    }
}
