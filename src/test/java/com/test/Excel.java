package com.test;

import com.utility.Constant;
import com.utility.ExcelUtils;

public class Excel {

	public static void main(String[] args) throws Exception{
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Objects");

		ExcelUtils.readExcel("homepage");

	}
}

