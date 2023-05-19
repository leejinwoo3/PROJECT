package Main;

import java.util.Scanner;
import DAO.*;
import DTO.*;
import Service.*;

public class Main {


	private static MemberDAO memberDao = new MemberDAO();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			System.out.println("명령어를 입력해주세요");
			System.out.print("> ");
			String command = sc.nextLine();
		
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			
			if (command.startsWith("new")) {
				
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("all")) {
				processAllCommand();
				continue;
			} else if (command.startsWith("delete")) {
				processDeleteCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}

	
	private static void processNewCommand(String[] arg) {
		
		if (arg.length != 2) {
			printHelp();
			
			return;
		}
		MemberRegisterService regSvc = new MemberRegisterService(memberDao);

		RegisterRequest req = new RegisterRequest();

		req.setEmail(arg[1]);
		req.setName(arg[2]);

		regSvc.regist(req);

	}

	private static void processAllCommand() {
		MemberAllService allSvc = new MemberAllService(memberDao);

		allSvc.selectAll();
	}

	private static void processDeleteCommand(String[] arg) {
		if (arg.length != 4) {

			printHelp();
			return;
		}
		MemberDeleteService delete = new MemberDeleteService(memberDao);
		delete.checkEmail(arg[1], arg[2]);
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법을 확인하세요.");
		System.out.println("모든 정보 출력 : all");
		System.out.println("정보 등록 : new [이메일] [이름] ");
		System.out.println("정보 삭제 : delete [이메일] [이름]");
		System.out.println("종료 : exit");
		System.out.println();
	}
}