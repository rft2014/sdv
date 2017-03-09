package sdv;

import java.util.Random;

public class passwordGenerator {
	static Random rd = new Random();
	static char[] zeichen = new char[62];

	public passwordGenerator() {
		zeichen[0] = 'a';
		zeichen[1] = 'b';
		zeichen[2] = 'c';
		zeichen[3] = 'd';
		zeichen[4] = 'e';
		zeichen[5] = 'f';
		zeichen[6] = 'g';
		zeichen[7] = 'h';
		zeichen[8] = 'i';
		zeichen[9] = 'j';
		zeichen[10] = 'k';
		zeichen[11] = 'l';
		zeichen[12] = 'm';
		zeichen[13] = 'n';
		zeichen[14] = 'o';
		zeichen[15] = 'p';
		zeichen[16] = 'q';
		zeichen[17] = 'r';
		zeichen[18] = 's';
		zeichen[19] = 't';
		zeichen[20] = 'u';
		zeichen[21] = 'v';
		zeichen[22] = 'w';
		zeichen[23] = 'x';
		zeichen[24] = 'y';
		zeichen[25] = 'z';
		zeichen[26] = 'A';
		zeichen[27] = 'B';
		zeichen[28] = 'C';
		zeichen[29] = 'D';
		zeichen[30] = 'E';
		zeichen[31] = 'F';
		zeichen[32] = 'G';
		zeichen[33] = 'H';
		zeichen[34] = 'I';
		zeichen[35] = 'J';
		zeichen[36] = 'K';
		zeichen[37] = 'L';
		zeichen[38] = 'M';
		zeichen[39] = 'N';
		zeichen[40] = 'O';
		zeichen[41] = 'P';
		zeichen[42] = 'Q';
		zeichen[43] = 'R';
		zeichen[44] = 'S';
		zeichen[45] = 'T';
		zeichen[46] = 'U';
		zeichen[47] = 'V';
		zeichen[48] = 'W';
		zeichen[49] = 'X';
		zeichen[50] = 'Y';
		zeichen[51] = 'Z';
		zeichen[52] = '0';
		zeichen[53] = '1';
		zeichen[54] = '2';
		zeichen[55] = '3';
		zeichen[56] = '4';
		zeichen[57] = '5';
		zeichen[58] = '6';
		zeichen[59] = '7';
		zeichen[60] = '8';
		zeichen[61] = '9';

	}

	public String createPassword() {
		String password = "";
		for (int i = 0; i < 7; i++) {
			char a = zeichen[rd.nextInt(62)];

			password = password + a;
		}
		return password;
	}

}
