package autoDoSomeThing;

import cainiaolicai.cnUser;
import cainiaolicai.cnlc_flow;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("~~~~主函数运行了~~~");
		cnUser zzq1 = new cnUser();
		zzq1.setTelephone("15923584508");
		zzq1.setPassword("d5c91303b3963ea463d4d97b616f06224f2469bdb4d9984ca696dd37c7059a7b");
		zzq1.setCnuserID("2568");
		zzq1.setDeviceID("31d2b13db676f532");
		zzq1.setUser_agent("Dalvik/2.1.0 (Linux; U; Android 6.0.1; Redmi 4A MIUI/V8.5.4.0.MCCCNED)");
//		zzq1.setAccept_secret("8eb478d177537ade7587bfafd52b1c9299e46c0a3881877469e6a5276e2a68d2");
		cnUser zzq2 = new cnUser();
		zzq2.setTelephone("17320413743");
		zzq2.setPassword("d5c91303b3963ea463d4d97b616f06224f2469bdb4d9984ca696dd37c7059a7b");
		zzq2.setCnuserID("850152");
		zzq1.setDeviceID("5ad2b13ddfdsf354");
		zzq2.setUser_agent("Dalvik/2.1.0 (Linux; U; Android 6.0.0; Redmi 4A MIUI/V8.5.3.0.MCCCNED)");
//		zzq2.setAccept_secret("8eb478d177537ade7587bfafd52b1c9299e46c0a3881877469e6a5276e2a68d2");
		cnUser zzq3 = new cnUser();
		zzq3.setTelephone("13512386223");
		zzq3.setPassword("d5c91303b3963ea463d4d97b616f06224f2469bdb4d9984ca696dd37c7059a7b");
		zzq3.setCnuserID("850649");
		zzq3.setDeviceID("db656fd41773b822");
		zzq3.setUser_agent("Dalvik/1.6.0 (Linux; U; Android 4.4.4; HM 2A MIUI/7.11.16)");
		cnUser zzq4 = new cnUser();
		zzq4.setTelephone("15310088377");
		zzq4.setPassword("d5c91303b3963ea463d4d97b616f06224f2469bdb4d9984ca696dd37c7059a7b");
		zzq4.setCnuserID("853034");
		zzq4.setDeviceID("39902e20922d0ec3");
		zzq4.setUser_agent("Dalvik/2.1.0 (Linux; U; Android 5.1; HUAWEI TAG-AL00 Build/HUAWEITAG-AL00)");
		
		cnlc_flow flow =  new cnlc_flow();
		flow.autoDo(zzq1);
		flow.autoDo(zzq2);
		System.out.println("~~~~主函数完了~~~");
	}

}
