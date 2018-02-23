/*
 * file name   : BaseFixture.java 
 * <br>copyright   : Copyright (c) 2018
 * <br>description : TODO<何时使用>[注意][示例]
 * <br>modified    : 
 * @author      <a href="mailto:zhangming@umpay.com">Thomas Zhang</a>
 * @version     1.0
 * @date        2018年2月8日 上午10:35:11
 */ 

package com.umpay.test.bdd; 



import org.concordion.api.extension.Extensions;
import org.concordion.ext.ParallelRunExtension;
import org.concordion.ext.timing.TimerExtension;

/*************************************************************************
 * description : TODO
 * @author      <a href="mailto:zhangming@umpay.com">Thomas Zhang</a>
 * @date        2018年2月8日 上午10:35:11
 * @version     1.0             
 *************************************************************************/
@Extensions({TimerExtension.class,ParallelRunExtension.class})
public abstract class BaseFixture {

}
