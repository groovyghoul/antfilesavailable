package com.bytemares.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import java.io.File;

public class FilesExist extends Task {

    private String fileList;
    private boolean jobSuccessful = true;

    public void execute() throws BuildException {
        String[] temp;
        String delimiter = ",";
        String endofline = System.getProperty("line.separator");
        String msg = endofline;

        temp = fileList.split(delimiter);

        for (int i=0; i < temp.length; i++) {
            boolean exists = (new File(temp[i])).exists();

            if (!exists) {
                jobSuccessful = false;
                msg += temp[i] + " does not exist." + endofline;
            }
        }

        if (!jobSuccessful) {
            throw new BuildException("Build failed" + endofline +  msg);
        }
    }
        public void setFileList(String fileList) {
        this.fileList = fileList;
        }
}