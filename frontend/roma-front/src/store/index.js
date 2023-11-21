import { createStore } from "vuex";

export default createStore({
    state(){
        return {
            post: {}
        }
    },
    mutations: {
        setPost(state, value) {
            state.post = value
        }
    }
})