package org.kh.shareware.mail.service;

import org.kh.shareware.mail.domain.Mail;
import org.kh.shareware.mail.domain.MailFile;
import org.kh.shareware.mail.domain.MailRec;
import org.kh.shareware.mail.domain.MailRef;

public interface MailService {

	

	public int registerMail(Mail mail);

	public int registerMailFile(MailFile mailFile);

	public int registerMailRec(MailRec mailRec);

	public int registerMailRef(MailRef mailRef);

	public int registerTemMail(Mail mail);

	public int registerTemMailRec(MailRec mailRec);

	public int registerTemMailRef(MailRef mailRef);

	public int registerTemMailMyFile(MailFile mailFile);

	

}
