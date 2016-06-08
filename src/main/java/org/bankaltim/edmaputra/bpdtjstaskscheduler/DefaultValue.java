package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import java.io.File;

public class DefaultValue {
	
	public static final String appDirectory = "bpdtjstaskscheduler";
    public static final String appFullDir  = System.getProperty("user.home")+File.separator+appDirectory+File.separator;
    public static final String corporateSongDir = appFullDir+File.separator+"CorporateSong.mp3";
    public static final String marsBankaltimDir = appFullDir+File.separator+"MarsBankaltim.mp3";
    public static final String doaPagiDir = appFullDir+File.separator+"DoaPagi.mp3";
    public static final String adzanDir = appFullDir+File.separator+"Adzan.mp3";

}
