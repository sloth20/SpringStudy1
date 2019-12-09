package com.sp.insa;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("insa.insaService")
public class InsaServiceImpl implements InsaService {
	@Override
	public void calculator(Insa dto) {

		int year, month, date;
		year = Integer.parseInt(dto.getBirth().substring(0, 4));
		month = Integer.parseInt(dto.getBirth().substring(5, 7));
		date = Integer.parseInt(dto.getBirth().substring(8, 10));
		String animal = null;

		switch (year % 12) {
		case 0:
			animal = "원숭이";
			break;
		case 1:
			animal = "닭";
			break;
		case 2:
			animal = "개";
			break;
		case 3:
			animal = "돼지";
			break;
		case 4:
			animal = "쥐";
			break;
		case 5:
			animal = "소";
			break;
		case 6:
			animal = "호랑이";
			break;
		case 7:
			animal = "토끼";
			break;
		case 8:
			animal = "용";
			break;
		case 9:
			animal = "뱀";
			break;
		case 10:
			animal = "말";
			break;
		case 11:
			animal = "양";
			break;
		}

		Calendar birthCal = Calendar.getInstance();
		Calendar currentCal = Calendar.getInstance();
		birthCal.set(year, month - 1, date);
		int difference = currentCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
		if (currentCal.get(Calendar.MONTH) < birthCal.get(Calendar.MONTH)
				|| currentCal.get(Calendar.MONTH) == birthCal.get(Calendar.MONTH)
						&& currentCal.get(Calendar.DATE) < birthCal.get(Calendar.DATE))
			difference--;

//		long birthDay = birthCal.getTimeInMillis();
//		long currentDay = currentCal.getTimeInMillis();
//		int difference = (int) ((currentDay - birthDay) / 1000 / 60 / 60 / 24 / 365.2425);

		int tax = 0;

		if (dto.getSal() + dto.getBonus() >= 3000000) {
			tax = (dto.getSal() + dto.getBonus()) * 3 / 100;
		} else if (dto.getSal() + dto.getBonus() >= 2000000) {
			tax = (dto.getSal() + dto.getBonus()) * 2 / 100;
		} else {
			tax = 0;
		}

		int realSal = dto.getSal() + dto.getBonus() - tax;

		dto.setAnimal(animal);
		dto.setRealAge(difference);
		dto.setTax(tax);
		dto.setRealSal(realSal);

	}

}
