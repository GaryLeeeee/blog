package com.garylee.blog.controller;

import com.garylee.blog.domain.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogControllerTest {
    @Autowired
    BlogController blogController;
    @Test
    public void get() throws Exception {
        Blog blog = blogController.get(3);
        System.out.println(blog.getContent());
    }

    @Test
    public void list() throws Exception {
        List<Blog> blogs = blogController.list();
        System.out.println(blogs.get(3).getContent());
    }

    @Test
    public void add() throws Exception {
        Blog blog = new Blog();
//        blog.setId(1);
        blog.setTitle("念在天涯，心在咫尺");
        blog.setContent("生命里，一些缱绻，无论素净，还是喧哗，都已经被岁月赋予了清喜的味道，一些闲词，或清新，或淡雅，总会在某一个回眸的时刻醉了流年，濡湿了柔软的心，冥冥之中，我们沿着呼唤的风声，终于在堆满落花的秋里，再次重逢，念在天涯，心在咫尺，我相信，一米阳光，才是我们最好的距离。<br>" +
                "缘起是诗，缘离是画，这些关于岁月，关于记忆的章节，终会被时光搁置在无法触及的红尘之外，曾经，你我一别经年，可风里，总有一段美丽会与我们不期而遇，一盏琉璃，半杯心悦，端然着那一份醉人的静，这安静行走的流年，总会被过往赋予一份清喜，一份浪漫。<br>" +
                "或许，习惯了着布衣素颜，让清心若雪，不喜张扬，不畏喧哗，守着一怀自己的素韵安静，在自己心中的半亩桃源，修篱种菊，喜欢与山水相依，与流水对话，让文字的墨香，依附在心灵的每一个角落，也喜欢，在闲时，端坐时光一隅，将一本书读到无字，将一盏茶喝到无味，将一个故事看到流泪.……心染尘香，不须有多少的柔情话语去讲，只要能够念起，便是一份温暖。<br>" +
                "再打开记忆的栅栏，取一壶往昔，与流年对坐，情有多深，心就有多疼，触不到的可惜，在挥手袖的风里滋养着忧伤，捻一缕清芬，看三千浮华，历历往事，素淡清雅，研一池墨香，植于眉心，相遇如梦，一直充满虔诚的无暇，这个十月，我用满怀的深情，打开文字的苍白，灵动的心事，穿过岁月的轩窗，迎面而来，我未曾离开，为何不见了原来这世间的繁华与葱笼？是时光的无情，还是流年容易沧桑，让所有的一切都如逝水匆匆，去了遥远的天涯？<br>" +
                "从此，我只想，淡泊一份宁静，让心中盈满诗意，只为赴你早就许下的盟誓，你不来，我怎么会轻易离开？一直，我喜欢叶落的静美，梦想着有一天和你一起看云水长天。我说：我韶华已老，岁月早已沧桑，已习惯了静默着独舞忧伤，然，这一眼凝眸，却注定得一世相随！或许我会静静陪你看一生的细水长流。<br>n" +
                "静默，看一场烟花如何绚烂自己的一生，忽然发现，我的梦想，有些什么已悄然变了，呼出的想念里，夏已调谢，秋已深浓，空气里有雨过的清新，却让秋沾染了好些沧桑的凉。一场花开的邂逅，静美了多少无言的守望？一帘烟雨的轮回，成全了多少天涯的相依？梦里天涯，许多人，终要忘记；许多事，总会随风，那些忧伤和叹息的深夜，依然会被突如其来的喧嚣触痛，我的星月，我的花开，曾经悄然用心铭刻，却也被时光的沙漏，渐渐滤去最初的繁华。<br>" +
                "我知道，那些关怀，那些温暖，你均是悄悄的给予，既已懂得，何须多言？！就让这份静美，永留心间。感谢岁月赠予我的这一份恩宠，亦感谢你让我途径你生命的四季，陪我走过的这一程山水，那么美。遇见，已是很美。就让我借一程云淡风轻。掬一捧水月在手，沾岁月的花香满衣。慎重在相逢的渡口写下：回忆有你，真是精彩。未来很美，许我和你一起笑对！可好？其实，情早已经入心，不要问，情深缘浅；不要说，相见恨晚。遇见已是很美，我们何须追问那些雨的印记，那些相伴的理由？一直想对你说：如果时光不老，情不会改变，如果你愿，我便放下所有矜持，携一颗琉璃素心，陪你静看一生最美的日落烟霞。");
        blog.setCreatetime("2018/8/29");
        blog.setReadnum(777);
        blog.setIstop(0);
        blogController.add(blog);
    }

}