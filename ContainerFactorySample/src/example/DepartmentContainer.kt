package example

import ContainerBase

data class DepartmentContainer(
    var department:Department,
    var deartmentAgent:DepartmentAgent?=null
):ContainerBase {
}