import request from '@/utils/request'

export default {
  //讲师列表
  getTeacherListPage(current, limit, teacherQuery) {
    return request({
      url: `/eduservice/edu-teacher/pageTeacherCondition/${current}/${limit}`,
      method: 'post',
      data: teacherQuery
    })
  },
  //删除
  deletedTeacherId(id) {
    return request({
      url: `/eduservice/edu-teacher/${id}`,
      method: 'delete',
    })
  },
  //添加讲师
  saveTeacher(eduTeacher) {
    return request({
      url: `/eduservice/edu-teacher/addTeacher`,
      method: 'post',
      data: eduTeacher
    })
  },
  //根据id查询讲师
  getTeacherInfo(id) {
    return request({
      url: `/eduservice/edu-teacher/getTeacher/${id}`,
      method: 'get'
    })
  },
  //修改讲师
  updateTeacher(teacher) {
    return request({
      url: `/eduservice/edu-teacher/updateTeacher/`,
      method: 'post',
      data: teacher
    })
  },
}
