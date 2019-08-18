package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializeTest {
	
	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;

	@Test
	public void testDataInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setName("�Ѹ�");
		member1.setPassword("member111");
		member1.setRole("ROLE_USER");
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("member2");
		member2.setName("�����");
		member2.setPassword("member222");
		member2.setRole("ROLE_ADMIN");
		memberRepo.save(member2);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("�Ѹ�");
			board.setTitle("�Ѹ��� ����� �Խñ� " + i);
			board.setContent("�Ѹ��� ����� �Խñ� ���� " + i);
			boardRepo.save(board);
		}

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("�����");
			board.setTitle("����ʰ� ����� �Խñ� " + i);
			board.setContent("����ʰ� ����� �Խñ� ���� " + i);
			boardRepo.save(board);
		}
	}
}
