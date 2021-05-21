//TODO　出来ればContainerFactoryをステートレスにしたいけど良い方法が思いつかず・・・
abstract class ContainerFactoryBase<T:ContainerBase> {
    protected var containerMap:Map<String, T>? = null
    fun getContainerList():List<T> = containerMap!!.values!!.toList()

    abstract fun bindAll()
}