package com.hanbit.lotto.controller;

import javax.swing.JOptionPane;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.serviceImpl.LottoServcieImpl;

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
				service.setLottos(lotto);
				int[][] lottos = service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
						System.out.print(lottos[i][j]+"\t");
					}
					System.out.println();
				}
				break;
			default:
				break;
			}
		}
	}
}
