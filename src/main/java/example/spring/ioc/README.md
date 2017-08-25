spring的核心包含spring ioc ，di ，aop  
ioc：  inverse of control  
字面意思是控制反转。
出现这个概念我想他的本意是解耦。将对象之间的关系通过容器来管理和控制。
这里模拟一下spring ioc  
实现原理：  （xml解析+反射）
- 解析xml文档，获取bean。  
- 通过反射，动态创建解析xml文档中定义的bena。  
- 将创建的出来的bean放入容器。


di注入实现思路：
1.解析xml文档（一级bean，属性）
2.解析出所有的bean
3.对于有依赖注入的bean，通过反射set进属性中


aop实现原理：  
