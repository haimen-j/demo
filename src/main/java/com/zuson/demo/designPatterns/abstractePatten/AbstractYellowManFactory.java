package com.zuson.demo.designPatterns.abstractePatten;

public abstract class AbstractYellowManFactory {

    protected Human createHuman(String humanUrl){
        Human human = null;
        try {
            Class<?> aClass = Class.forName(humanUrl);
            human  = (Human)aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return human;
    }

}
