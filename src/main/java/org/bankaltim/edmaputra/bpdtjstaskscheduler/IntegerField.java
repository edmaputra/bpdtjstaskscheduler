package org.bankaltim.edmaputra.bpdtjstaskscheduler;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class IntegerField extends JTextField {

	private static final long serialVersionUID = -7572129978637657175L;

	public IntegerField() {
		super();
	}

	public IntegerField(int cols) {
		super(cols);
	}

	@Override
	protected Document createDefaultModel() {
		return new UpperCaseDocument();
	}

	static class UpperCaseDocument extends PlainDocument {

		private static final long serialVersionUID = -2227866960315198104L;

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

			if (str == null) {
				return;
			}

			char[] chars = str.toCharArray();
			boolean ok = true;

			for (int i = 0; i < chars.length; i++) {

				try {
					Integer.parseInt(String.valueOf(chars[i]));
				} catch (NumberFormatException exc) {
					ok = false;
					break;
				}

			}

			if (ok)
				super.insertString(offs, new String(chars), a);

		}
	}

}
