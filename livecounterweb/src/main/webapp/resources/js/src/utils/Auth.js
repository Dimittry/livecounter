var axios = require('axios');


class AuthImpl {
    constructor() {
        this.makeRequest.bind(this);
    }
    login(username, password, callback) {
        let userInfo = this.getUserAuthInfo();
        console.log("step 1");
        if(userInfo) {
            if(callback) callback(true);
            return
        }
        console.log("step 2");

        if(!username && !password) {
            if(callback) callback(false)
            return
        }
        console.log("step 3");

        this.makeRequest(username, password, callback);
    }

    setUserAuthInfo(userAuthInfo) {
        localStorage.setItem("userAuthInfo", JSON.stringify(userAuthInfo));
    }

    getUserAuthInfo() {
        return JSON.parse(localStorage.getItem("userAuthInfo"));
    }

    isLoggedIn() {
        return !!localStorage.getItem("userAuthInfo");
    }

    makeRequest(username, password, callback) {
        var self = this;
        axios({
            method: 'post',
            withCredentials: true,
            url: '/oauth/token?grant_type=password&username='+username+'&password='+password,
            responseType : 'json',
            headers : {'X-Requested-With': 'XMLHttpRequest'},
            auth: {
                username: 'myclient',
                password: 'password123'
            }
        }).then(function(response) {
            console.log(response);
            if(response.data) {
                if(callback) callback(true);
                self.setUserAuthInfo(response.data);
            } else {
                if(callback) callback(false);
            }

        });
    }

    logout() {
        localStorage.removeItem("userAuthInfo") ;
    }
}

module.exports = new AuthImpl()
// module.exports = {
//     setUserAuthInfo : function(userAuthInfo) {
//         localStorage.setItem("userAuthInfo", JSON.stringify(userAuthInfo));
//     },
//
//     getUserAuthInfo : function() {
//         return JSON.parse(localStorage.getItem("userAuthInfo"));
//     },
//
//     isLoggedIn : function() {
//         return !!localStorage.getItem("userAuthInfo");
//     }
// };