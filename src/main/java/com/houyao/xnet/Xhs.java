package com.houyao.xnet;

import com.erayt.xnet4j.XNetData;
import com.erayt.xnet4j.XNetHandler;
import com.erayt.xnet4j.XNetSocket;

public class Xhs implements XNetHandler {

	@Override
	public void connectionClosed(XNetSocket arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dataRead(XNetSocket arg0, XNetData arg1) {
		// TODO Auto-generated method stub
//       System.out.println("dataRead "+arg1.getTitle());
//       System.out.println("======================"+arg1.getTitle());
       System.out.println("=====================["+arg1.toString()+"]");
	}

	@Override
	public void exceptionCaught(XNetSocket arg0, Throwable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loginOK(XNetSocket arg0) {
		// TODO Auto-generated method stub
         System.out.println(arg0);
	}

}
