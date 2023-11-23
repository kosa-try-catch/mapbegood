import { createRouter, createWebHistory } from 'vue-router'
import Login from '../components/pages/Login.vue'
//경로 별칭: @은 'src/'경로를 의미함

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: Login },
        // { path: '/about', component: About },
        // { path: '/members', component: Members },

        //동적라우팅 방법
        // {path: '/members/:id', component: MemberInfo}
        // {path: '/members/1', component: MemberAladin},
        // {path: '/members/2', component: MemberJasmin},
        // {path: '/members/3', component: MemberGenie}
        //멤버별로 개별설정하면 힘드니까 동적라우팅 이용
    ]
})
export default router;