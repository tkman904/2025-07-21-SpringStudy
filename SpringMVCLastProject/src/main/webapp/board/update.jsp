<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
   margin: 0px auto;
   width:800px;
}
</style>
</head>
<body>
  <div class="container" id="board_app">
    <div class="row">
      <h3 class="text-center">수정하기</h3>
      <table class="table">
        <tr>
          <th width=15% class="text-center">이름</th>
          <td width=85%>
            <input type=text ref="name" size=20 class="input-sm" v-model="name">
          </td>
        </tr>
        <tr>
          <th width=15% class="text-center">제목</th>
          <td width=85%>
            <input type=text ref="subject" size=45 class="input-sm" v-model="subject">
          </td>
        </tr>
        <tr>
          <th width=15% class="text-center">내용</th>
          <td width=85%>
            <textarea rows="10" cols="45" ref="content" v-model="content"></textarea>
          </td>
        </tr>
        <tr>
          <th width=15% class="text-center">비밀번호</th>
          <td width=85%>
            <input type=password ref="pwd" size=15 class="input-sm" v-model="pwd">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn-sm btn-primary" type=button @click="update()">수정</button>
            <button class="btn-sm btn-primary" type=button onclick="javascript:history.back()">취소</button>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <script type="importmap">
   {	
      	"imports": {
         	"vue": "https://unpkg.com/vue@3/dist/vue.esm-browser.js"
      	}
   }
  </script>
  <script type="module">
   	import {createApp} from "vue"
   	const app = createApp({
     	data() {
        	return {
            	name: '',
            	subject: '',
            	content: '',
            	pwd: '',
            	msg: '',
            	no: ${no}
        	}
     	},
     	mounted() {
        	axios.get('http://localhost:8080/web/board/update_vue.do', {
				params: {
            		no:this.no
            	}
        	}).then(res=> {
				// then((res)=>{})
            	this.name = res.data.name
            	this.subject = res.data.subject
            	this.content = res.data.content
        	})
     	},
     	methods: {
       		update() {
           		this.dataRecv()
       		},
       		async dataRecv() {
          		if(this.name==="") {
             		this.$refs.name.focus()
             		return
          		}
          		if(this.subject==="") {
             		this.$refs.subject.focus()
             		return
          		}
          		if(this.content==="") {
             		this.$refs.content.focus()
             		return
          		}
          		if(this.pwd==="") {
             		this.$refs.pwd.focus()
             		return
          		}

          	/*
               	RestFul 
                axios.put : UPDATE
                axios.get : SELECT
                axios.post : INSERT
                axios.delete : DELETE
                => web : get/post
          	 */
          		await axios.put('http://localhost:8080/web/board/update_ok_vue.do', {
               		name: this.name,
               		subject: this.subject,
               		content: this.content,
               		pwd: this.pwd,
               		no: this.no
          		}).then(res=> {
					if(res.data.msg==='yes') {
                		location.href = '../board/list.do'
              		} else {
                		alert("수정에 실패하셨습니다!!")
              		}
          		})
      	 	}
     	}
   	})
   	app.mount("#board_app")
  </script>
</body>
</html>