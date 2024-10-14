
package com.reusablecodescott;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FormatWidth2 {

	public static Scanner scanner = new Scanner(System.in);
	// public static int fieldWidthCalculator(int greatestFieldWidth) throws
	// Exception {
	// int newFieldWidth = 0;
	//
	// if (greatestFieldWidth < 0) {
	// throw new Exception();
	// }
	//
	// newFieldWidth=(Math.round(greatestFieldWidth/10)) * 10;
	//
	//
	// return newFieldWidth;
	//
	// }

	public static List<Integer> findCorrectFieldWidth(final Connection connB, String tableName) {
		int tempFieldWidth = 0;
		int greatestFieldWidth = 0;

		try {

			String queryStr = "SELECT * FROM " + tableName + ";";

			Statement stmt = connB.createStatement();

			ResultSet rs = stmt.executeQuery(queryStr);

			ResultSetMetaData rsmd = rs.getMetaData();

			final int columnsCount = rsmd.getColumnCount();
			System.out.println("columnsCount = " + columnsCount);

			final List<List<String>> rowList = new LinkedList<List<String>>();
			final List<Integer> columnWidth = new ArrayList<Integer>();

			int i = 0;
			System.out.println("Press Enter-----------------");
			pressEnter();

			while (rs.next()) {
				i = 1;
				final List<String> columnList = new LinkedList<String>();

				while (i < (columnsCount + 1)) {

					String value = rs.getString(i).trim();

					columnList.add(value);

					i++;
				}
				rowList.add(columnList);

			}

			System.out.println("Press Enter****************");
			pressEnter();

			// System.out.println("rowList.size() = " + rowList.size());
			// i = 0;
			// int j = 0;
			//
			// while (i < rowList.size()) {
			//
			// j = 0;

			// while (j < columnsCount) {
			// System.out.println(
			// "rowList.get(" + i + ").get(" + j + ") =" + rowList.get(i).get(j));
			// tempFieldWidth = rowList.get(i).get(j).toString().length();
			// System.out.println("tempFieldWidth = " + tempFieldWidth);
			// if (tempFieldWidth > greatestFieldWidth) {
			// greatestFieldWidth = tempFieldWidth;
			//
			// }
			//
			// // System.out.printf("%-50s", rowList.get(i).get(j));
			// j++;
			//
			// }
			//
			//
			// System.out.println();
			// i++;
			// }
			//

			int j = 0;
			i = 0;
			while (i < columnsCount) {

				j = 0;

				while (j < rowList.size() - 1) {

					System.out.println(
							"rowList.get(" + j + ").get(" + i + ") =" + rowList.get(j).get(i));
					tempFieldWidth = rowList.get(j).get(i).toString().length();
					System.out.println("tempFieldWidth = " + tempFieldWidth);
					if (tempFieldWidth > greatestFieldWidth) {
						greatestFieldWidth = tempFieldWidth;

					}

					// System.out.printf("%-50s", rowList.get(i).get(j));
					j++;

				}

				columnWidth.add(greatestFieldWidth);

				greatestFieldWidth = 0;

				System.out.println();
				i++;
			}

			for (int x : columnWidth) {
				System.out.println(x);

			}

			for (int z = 0; z < columnWidth.size(); z++) {

				int temp = 0;

				temp = Math.round((columnWidth.get(z) / 10) + 2) * 10;

				columnWidth.set(z, temp);

			}

			for (int x : columnWidth) {
				System.out.println(x);

			}

			System.out.println("Press Enter");
			pressEnter();

			// greatestFieldWidth = (Math.round(greatestFieldWidth / 10) + 1) * 10;

			return columnWidth;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// will show what type of error & the message returned from the
			// error
			e.printStackTrace();
			System.out.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}

		return null;

	}

	public static void pressEnter() {

		scanner.nextLine();
	}

}
