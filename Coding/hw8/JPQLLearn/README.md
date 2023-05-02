# 使用JPQL的方法
* 使用 `@Query`
  * 在对应的Repository中直接加上这个注解然后在注解中加上JPQL或者SQL
  * 参数的使用方法也有IndexParam和NamedParam两种方法
* 使用 `@NamedQuery`
  * 首先要在对应的Entity里添加这个NamedQuery
  * 需要自己先创建一个对应的JPQL接口，然后创建一个类来实现这个JPQL中的所有方法
  * 实现的时候需要使用到EntityManager