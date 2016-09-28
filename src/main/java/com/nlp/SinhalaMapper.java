package com.nlp;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SinhalaMapper {

	public boolean compaire(String realtext, String text, Dictionary dictionary) {
		boolean tokenexist = false;
		String[] texttokenz = tokenizeString(text);
		int texttokenzsize = texttokenz.length;

		String[] realtexttokens = tokenizeString(realtext);
		int realtexttokenssize = realtexttokens.length;

		boolean[] textExist = new boolean[realtexttokenssize];

		for (int i = 0; i < texttokenzsize; i++) {
			tokenexist = false;
			HashMap<String, String> tokenz = dictionary.getSimilarTokens(texttokenz[i]);
			for (int j = 0; j < realtexttokenssize; j++) {
				String token = tokenz.get(realtexttokens[j]);
				if (token != null) {
					textExist[j] = true;
					break;
				}

			}

		}
		int exsittextcount = 0;
		for (boolean textb : textExist) {
			if (textb) {
				exsittextcount++;
			}
		}
		if (exsittextcount == texttokenzsize) {
			return true;
		}
		return false;
	}

	public String[] tokenizeString(String text) {
		String[] tokens = null;
		try {
			byte[] utf8Bytes = text.getBytes("UTF-8");
			text = new String(utf8Bytes, "UTF-8");
			tokens = text.split(" ");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tokens;
	}

	public void printTokenz(String[] tokenz) {
		for (String token : tokenz) {
			System.out.println(token);

		}
	}

}
