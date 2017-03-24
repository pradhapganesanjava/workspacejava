package com.pg.dp.cascademethod;

public class CascadeMethod {

	public static void main(String[] args) {

		Mailer_Simple mailerSimple = new Mailer_Simple();
		mailerSimple.toMailer("x@x.com");
		mailerSimple.fromMailer("f@f.com");
		mailerSimple.subMailer("sub");
		mailerSimple.msgMailer("msg");
		mailerSimple.sendMailer();

		//Cascade patter is like builder patter. but mutable.
		Mailer_Cascade mailerCascade = new Mailer_Cascade()
												.toMailer("to@to.com")
												.fromMailer("f@f.com")
												.subMailer("sub")
												.msgMailer("msg")
												.sendMailer();

	}

}

class Mailer_Cascade{
	private Mailer_Cascade mailer = new Mailer_Cascade(); 
	public Mailer_Cascade toMailer(String to){
		System.out.println("set to Mailer ");
		return mailer;
	}
	public Mailer_Cascade fromMailer(String from){
		System.out.println("set from Mailer ");
		return mailer;
	}
	public Mailer_Cascade subMailer(String sub){
		System.out.println("set sub Mailer ");
		return mailer;
	}
	public Mailer_Cascade msgMailer(String msg){
		System.out.println("set msg Mailer ");
		return mailer;
	}
	public Mailer_Cascade sendMailer(){
		System.out.println("send Mailer ");
		return mailer;
	}
}

class Mailer_Simple{
	public void toMailer(String to){
		System.out.println("set to Mailer ");
	}
	public void fromMailer(String from){
		System.out.println("set from Mailer ");
	}
	public void subMailer(String sub){
		System.out.println("set sub Mailer ");
	}
	public void msgMailer(String msg){
		System.out.println("set msg Mailer ");
	}
	public void sendMailer(){
		System.out.println("send Mailer ");
	}
}