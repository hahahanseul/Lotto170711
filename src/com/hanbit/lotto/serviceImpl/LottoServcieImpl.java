package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServcieImpl implements LottoService{
	int[][] lottos;
	int[] lotto;  //돈과 상관없이 생성되는 한 줄(숫자6) 로또
	private int count; //돈에 따른 줄 5를 넘을 수 없고 
	//로또는 1~45사이의 숫자
	public LottoServcieImpl() {
		count =0;
		lotto = new int[6];
	}
	
	@Override
	public void setCount(LottoBean bean) {
		int x = bean.getMoney()/1000;
		if(x>=5) {
			x=5;
		}else {
			 x = bean.getMoney()/1000;
		}
		this.count=x;
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
		int i = 0;
		for(count=0;count<lottos.length;count++) {
			while(true) {
				int num=bean.getNumber();
				if(isDuplication(count, num)) {
					continue;
				}
				lottos[count][i] = num;
				i++;
				if(i==lottos[count].length) {
					sort(lottos[count]);
					i=0;
					break;
				}
			}
		}

	}
	@Override
	public int[][] getLottos() {
		// 만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		boolean result = false;
		for(int i=0;i<lottos[count].length;i++) {
			if(lottos[count][i]==num) {
				result=true;
			}
		}
		return result;
	}

	@Override
	public void sort(int[] arr) {
		// 오름차순으로 정렬 swap정렬
		int temp =0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
}
