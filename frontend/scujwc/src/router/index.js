import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login/Login'
import Error from '@/components/404'
import Info from '@/components/InfoMain/Info'
import detail from '@/components/InfoMain/detail'
import userHome from '@/components/InfoMain/Details/userHome'
import personInfo from '@/components/InfoMain/Details/personInfo'
import courseManagement from '@/components/InfoMain/Details/courseManagement'
import examinationManagement from '@/components/InfoMain/Details/examinationManagement'
import gradeManagement from '@/components/InfoMain/Details/gradeManagement'
import libraryService from '@/components/InfoMain/Details/libraryService'
import teachingResource from '@/components/InfoMain/Details/teachingResource'
import setting from '@/components/InfoMain/Details/setting'


Vue.use(Router)


const router = new Router({
  // mode: 'history', //本地测试打包时注释掉history模式
  routes: [{
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/info',
      name: 'info',
      component: Info
    },
    {
      path: '/detail',
      name: 'detail',
      component: detail,
      children: [{
          path: '',
          component: userHome
        },
        {
          name: 'userHome',
          path: 'userHome',
          component: userHome
        },
        {
          name: 'personInfo',
          path: 'personInfo',
          component: personInfo
        },
        {
          name: 'courseManagement',
          path: 'courseManagement',
          component: courseManagement
        },
        {
          name: 'examinationManagement',
          path: 'examinationManagement',
          component: examinationManagement
        },
        {
          name: 'gradeManagement',
          path: 'gradeManagement',
          component: gradeManagement
        }, {
          name: 'libraryService',
          path: 'libraryService',
          component: libraryService
        }, {
          name: 'teachingResource',
          path: 'teachingResource',
          component: teachingResource
        },
        {
          name: 'setting',
          path: 'setting',
          component: setting
        },
        {
          name: 'errorInDetail',
          path: '*',
          component: Error
        }
      ]
    },
    {
      path: '*',
      name: 'error',
      component: Error
    }
  ]
});
router.beforeEach((to, from, next) => {
  console.log(to);
  console.log(from);
  next();
})


export default router;
