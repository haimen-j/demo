package com.zuson.demo.designPatterns.proxyPattern;

public class Songji implements KindMan {

    private KindMan kindMan;

    //默认时给王宝强代理的代理人
    public Songji(){
        this.kindMan = new Wangbaoqiang();
    }

    //也可以给别人代理
    public Songji(KindMan kindMan){
        this.kindMan = kindMan;
    }

    @Override
    public void canActing() {
        this.kindMan.canActing();
    }

    @Override
    public void canSing() {
        this.kindMan.canSing();
    }
}
