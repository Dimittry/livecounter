// class Auth {
//
//     setUserAuthInfo(userAuthInfo) {
//         localStorage.setItem("userAuthInfo", JSON.stringify(userAuthInfo));
//     }
//
//     getUserAuthInfo() {
//         return JSON.parse(localStorage.getItem("userAuthInfo"));
//     }
//
//     isSignIn() {
//         return !!localStorage.getItem("userAuthInfo");
//     }
// }

module.exports = {
    setUserAuthInfo : function(userAuthInfo) {
        localStorage.setItem("userAuthInfo", JSON.stringify(userAuthInfo));
    },

    getUserAuthInfo : function() {
        return JSON.parse(localStorage.getItem("userAuthInfo"));
    },

    isSignIn : function() {
        return !!localStorage.getItem("userAuthInfo");
    }
};