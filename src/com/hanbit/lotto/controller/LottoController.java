package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServcieImpl;

public class LottoController {
	public static void main(String[] args) {
		LottoService service = new LottoServcieImpl();
		LottoBean lotto = new LottoBean();
		while(true) {
			switch(JOptionPane.showInputDialog("0.exit 1.buy")) {
			case "0":
				return;
			case "1":
				int money = Integer.parseInt(JOptionPane.showInputDialog("How Much??"));
				lotto.setMoney(money);
				StringBuffer buff = new StringBuffer();
				service.setLottos(lotto);
				int[][] lottos = service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
						//System.out.print(lottos[i][j]+"\t");
						buff.append(lottos[i][j]+"\t");
					}
					buff.append("/");
				}
				int lottoSerialNo=(int)(Math.random()*99999+10000);
				File output = new File("C:\\Users\\hanbit\\JavaProjects\\lottos\\" + lottoSerialNo+".txt");
				BufferedWriter bw = null;
				String[] lottoPrint=buff.toString().split("/");
				try {
					bw = new BufferedWriter(new FileWriter(output));    //file은 filewriter에 얹혀져야 이제 뭔가 기능을 하는겨 
					for(String s: lottoPrint) {
						s += System.getProperty("line.separator");
						bw.write(s);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						bw.flush(); //버퍼를 다 비워버려라
						bw.close(); //그리고 문을 닫으쇼! flush랑 짝꿍이라능
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			default:
				break;
			}
		}
	}
}
