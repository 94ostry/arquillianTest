package com.postrowski.foo;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by postrowski on 2016-12-31.
 */
@RunWith(Arquillian.class)
public class FooServiceIT {

    @Inject
    FooService fooService;

    @Deployment
    public static JavaArchive create() {

        return ShrinkWrap.create(JavaArchive.class)
                .addClass(FooService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void shouldSum() {

        //given
        int a = 2;
        int b = 3;

        //when
        int sum = fooService.sum(a, b);

        //then
        Assert.assertEquals(a + b, sum);
    }
}
