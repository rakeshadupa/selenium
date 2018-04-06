package com.maven.sample;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

public class SendEmail {

	@Test
	public void email() throws EmailException {
		// SimpleEmail email = new SimpleEmail();
		// email.setHostName("smtp.gmail.com");
		// email.setSmtpPort(587);
		// email.setAuthenticator(new
		// DefaultAuthenticator("rakeshadupa96@gmail.com","recommend139"));
		// email.setSSL(true);
		// email.setFrom("rakeshadupa96@gmail.com");
		// email.setSubject("TestMail");
		// email.setMsg("This is a test mail ...");
		// email.addTo("rakeshadupa931@gmail.com");
		// email.send();
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("/home/sanketh/Documents/eclipse workspace/selenium_scripts/sample_maven_project/test-output/emailable-report.html");

		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("reports");
		attachment.setName("rakesh");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("tvisha.com");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");
		email.setFrom("webmasters@tvisha.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("webmasters@tvisha.com", "webmasterstvi123"));
		email.setSSL(true);
		email.addTo("rakesh.adupa@tvisha.in");
		email.attach(attachment);
		email.send();

	}
}
