package com.hogan.model;

import org.junit.Before;
import org.junit.Test;

import com.hogan.dao.BookDao;
import com.hogan.util.ApplicationContextUtil;

public class BookTest {
	private BookDao bookDao = null;
	
	@Before
	public void initBookDao() {
		bookDao = ApplicationContextUtil.getBean("bookDao");
	}
	
	@Test
	public void createBookTest() {
		Book book = new Book();
		book.setTitle("你好");
		book.setAuthor("白中英，谢松云");
		book.setDiscription("《数字逻辑(附光盘第6版立体化教材十二五普通高等教育本科国家级规划教材)》为“十二五”普通高等教育本科国家级规划教材。全书内容共分8 章；第0章成才之路，第1章开关理论基础，第2章组合逻辑，第3章时序逻辑，第4章存储逻辑，第5章可编程逻辑，第6章数字系统，第7章A／D转换、 D／A转换。教学内容具有基础性和时代性，从理论与实践两方面解决了与后续课程的衔接。《数字逻辑(附光盘第6版立体化教材十二五普通高等教育本科国家级规划教材)》是作者百中英对“数字逻辑”课程体系、教学内容、教学方法和教学手段进行综合改革的具体成果。本书内容全面，取材新颖，概念清楚，系统性强，注重实践教学和能力培养，形成了文字主副教材、多媒体CAI课件、试题库、习题库、实验仪器、教学实验、课程设计等综合配套的立体化教学体系。全书可作为高等院校计算机、电子、通信、自动控制等信息类专业的技术基础课教材，也可作为成人自学考试用书");
		book.setAmount(26.2);
		book.setCount(10);
		book.setImageUrl("szlj.jpg");
		
		Book book1 = new Book();
		book1.setTitle("算法导论");
		book1.setAuthor("殷建平，徐云，王刚");
		book1.setDiscription("在有关算法的书中，有一些叙述非常严谨，但不够全面；另一些涉及了大量的题材，但又缺乏严谨性。本书将严谨性和全面性融为一体，深入讨论各类算法，并着力使这些算法的设计和分析能为各个层次的读者接受。全书各章自成体系，可以作为独立的学习单元；算法以英语和伪代码的形式描述，具备初步程序设计经验的人就能看懂；说明和解释力求浅显易懂，不失深度和数学严谨性。\n全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。");
		book1.setAmount(91.1);
		book1.setCount(10);
		book1.setImageUrl("sfdl.jpg");
		
		Book book2 = new Book();
		book2.setTitle("C#入门经典");
		book2.setAuthor("齐立波，黄俊伟");
		book2.setDiscription("《C#入门经典 系列是屡获殊荣的C#名著和超级畅销书。最新版的 C#入门经典(第6版) 面向编程新手，全面介绍使用C# 2012和.NET Framework编写程序的基础知识。本书无与伦比的作者团队与您分享多年积累的C#和.NET Framework使用经验，首先简明扼要地介绍这两种技术，解释其含义、相互关系以及使用原因，然后循序渐进地讨论编程基础知识、Web编程、桌面编程以及数据访问技术。本书的讲解详明透彻，以　　通俗易懂的方式分步骤解析大量基础性示例，为您提供了在实践中锻炼运用新学知识的机会。");
		book2.setAmount(91.1);
		book2.setCount(10);
		book2.setImageUrl("sfdl.jpg");
		
//		bookDao.saveOrUpdate(book);
//		bookDao.saveOrUpdate(book1);
		bookDao.saveOrUpdate(book2);
	}
	
	@Test
	public void getBookTest() {
		Book book1 = new Book();
		book1.setId(5);
		Book book2 = new Book();
		book2.setId(7);
		Book book11 = bookDao.getById(book1);
		Book book22 = bookDao.getById(book2);
		System.out.println(book11);
		System.out.println(book22);
	}
	
}
