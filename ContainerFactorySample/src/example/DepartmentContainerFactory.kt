package example

import ContainerFactoryBase

class DepartmentContainerFactory(
    var searchCondition: DepartmentSearchCondition,
    var searchOption: DepartmentSearchOption
):ContainerFactoryBase<DepartmentContainer>() {
    init {
        //基本検索を行い情報取得する
        //var departmentList:List<Department> = dao.load(departmentSearchCondition)
        //今回は疑似的に作る
        var departmentList:List<Department> = listOf(
            Department("00001", "部門１"),
            Department("00002","部門２"),
            Department("00003","部門３")
        )
        //取得したListをMapに変換し保存
        super.containerMap = departmentList.map {
            it.deparmentId to DepartmentContainer(department=it)
        }.toMap()
        bindAll()
    }

    override fun bindAll() {
        if(searchOption.depatmentAgent) {
            bindDepartmentAgent()
        }
    }

    private fun bindDepartmentAgent() {
        //単一キーなら
        val departmentIdList:List<String> = getContainerList().map { it.department.deparmentId }
        //復号キーなら
        val keyList:List<DepartmentAgentSearchCondition>
            = getContainerList().map {
                DepartmentAgentSearchCondition(departmentId = it.department.deparmentId)
            }
        //Conditionの中にListを持たせてるパターンでも
        //DepartmentSearchCondition(departmentId=getContaienrList().map{it.department.departmentId})で可能

        //DepartmentAgentのListを検索
        //val departmentAgentList = dao.load(keyList)
        //便宜的に中で生成
        val departmentAgentList:List<DepartmentAgent> = listOf(
            DepartmentAgent("00001", "0000A"),
            DepartmentAgent("00002", "0000B"),
            DepartmentAgent("00009", "0000X")//通常は起きえないけどマップできないものを設定
        )
        departmentAgentList.forEach{
            val container = containerMap!![it.departmentId]
            container?.deartmentAgent = it
        }
    }

    data class DepartmentSearchOption(
        val depatmentAgent:Boolean,
        val hogehoge:Boolean
    )
}