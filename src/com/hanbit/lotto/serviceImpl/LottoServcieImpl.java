package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServcieImpl implements LottoService{
	int[][] lottos;
	int[] lotto;  //돈과 상관없이 생성되는 한 줄(숫자6) 로또
	private int count; //돈에 따른 줄 5를 넘을 수 없고 
	//로또는 1~45사이의 숫자
	@Override
	public void setCount(LottoBean bean) {
		this.count=(bean.getMoney()/1000>=5)?5:bean.getMoney()/1000;
	}
	@Override
	public int getCount() {
		// 해당 로또수만큼 출력
		return count;
	}
	@Override
	public void setLottos(LottoBean bean) {
		// 로또 만들기
		setCount(bean);
		lottos = new int[count][6];
		for(count=0;count<lottos.length;count++) {
			for(int i=0;i<6;i++) {
				int num = bean.getNumber();
				if(!isDuplication(count, num)) {
					lottos[count][i]=num;
				}else {
					i--;
				}
				
			}
			sort(lottos[count]);
		}
	}
	@Override
	public int[][] getLottos() {
		// 만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		boolean flag = false;
		for(int i=0;i<6;i++) {
			if(num == lottos[count][i]) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void sort(int[] arr) {
		// 오름차순으로 정렬 swap정렬
		int temp =0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
}
