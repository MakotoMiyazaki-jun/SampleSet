import example.DepartmentContainerFactory
import example.DepartmentSearchCondition

fun main() {
    val departmentContainer = DepartmentContainerFactory(
        DepartmentSearchCondition("00001"),
        DepartmentContainerFactory.DepartmentSearchOption(true, false)
    ).getContainerList()
    departmentContainer.forEach{
        println("============================")
        println(it.department)
        println(it.deartmentAgent)
    }

//    val departmentContainerFactory = DepartmentContainerFactory(
//        DepartmentSearchCondition(),
//        DepartmentContainerFactory.DepartmentSearchOption(XXDivList.contains(XXDiv.XXX), XXDivList.contains(XXDiv.XXX))
//    )
}