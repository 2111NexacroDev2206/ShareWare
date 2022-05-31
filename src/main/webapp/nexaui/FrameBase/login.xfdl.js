(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("login");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_login", this);
            obj._setContents("<ColumnInfo><Column id=\"ID\" type=\"STRING\" size=\"256\"/><Column id=\"PW\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("div_login","396","168","482","380",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("Div00");
            obj.set_border("1px solid darkgray");
            obj.set_borderRadius("5px");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","73","185","111","32",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("0");
            obj.set_text("PASSWORD");
            obj.set_font("13pt/normal \"Changa\"");
            this.div_login.addChild(obj.name, obj);

            obj = new Edit("edt_id","194","140","215","34",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("1");
            this.div_login.addChild(obj.name, obj);

            obj = new Edit("edt_pw","194","184","215","34",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("2");
            obj.set_password("true");
            this.div_login.addChild(obj.name, obj);

            obj = new Button("Button00","96","280","288","41",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("3");
            obj.set_text("로그인");
            obj.set_background("#5a86cd");
            obj.set_color("#ffffff");
            obj.set_font("normal 13pt/normal \"Arial\"");
            obj.set_border("0px none");
            this.div_login.addChild(obj.name, obj);

            obj = new CheckBox("chk_idSave","323","236","86","25",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("4");
            obj.set_text(" 계정저장");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("right");
            obj.set_value("true");
            this.div_login.addChild(obj.name, obj);

            obj = new Static("Static01","73","143","111","32",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("5");
            obj.set_text("USERID");
            obj.set_font("13pt/normal \"Changa\"");
            this.div_login.addChild(obj.name, obj);

            obj = new Static("st_msg","100","228","194","30",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("6");
            obj.set_color("red");
            obj.set_text("");
            this.div_login.addChild(obj.name, obj);

            obj = new Static("Static00","79","31","334","77",null,null,null,null,null,null,this.div_login.form);
            obj.set_taborder("7");
            obj.set_text("ShareWare");
            obj.set_color("#5a86cd");
            obj.set_font("50pt/normal \"Changa\"");
            obj.set_textAlign("center");
            obj.set_fittocontents("both");
            this.div_login.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","div_login.form.edt_id","value","ds_login","ID");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","div_login.form.edt_pw","value","ds_login","PW");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("login.xfdl", function() {
        //div가운데로
        this.login_onsize = function(obj,e)
        {
        	var objApp = nexacro.getApplication();
        	var nLeft = (objApp.mainframe.width / 2) - (this.div_login.form.getOffsetWidth() / 2);
        	var nTop = (objApp.mainframe.height / 2) - (this.div_login.form.getOffsetHeight() / 2);

        	this.div_login.setOffsetLeft(nLeft);
        	this.div_login.setOffsetTop(nTop);
        };
        this.login_onload = function(obj,e)
        {
        	this.login_onsize();

        	var sGetId = nexacro.getPrivateProfile("userId");
        	if (sGetId != null)
        	{
        		this.div_login.form.edt_id.set_value(sGetId); //아이디 저장
        		this.div_login.form.chk_idSave.set_value(true);
        	}
        };

        this.btn_login = function(obj,e)
        	{
        	var sId = this.div_login.form.edt_id.value;
        	var sPw = this.div_login.form.edt_pw.value;

        	if(sId == null || sId.length == 0){
        		this.div_login.form.st_msg.set_text("아이디를 입력하세요");
        		this.div_login.form.edt_id.setFocus();
        		return;
        	}
        	if(sPw == null || sPw.length == 0){
        		this.div_login.form.st_msg.set_text("비밀번호를 입력하세요");
        		this.div_login.form.edt_pw.setFocus();
        		return;
        	}

        	this.fn_login(sId, sPw);
        };


        this.Edit_oninput = function(obj,e)
        {
        	this.div_login.form.st_msg.set_text("");
        };

        this.fn_login = function(sId, sPw)
        {
        	if(this.div_login.form.chk_idSave.value == "1"){
        		nexacro.setPrivateProfile("userId", sId);
        	}
        /*
        	this.transaction("svcLogin"
        				   , "KhURL::login.jsp"
        				   , "in_ds=ds_login"
        				   , "gds_menu=out_menu"
        				   , "paramId=" + sId + "paramPw=" + sPw
        				   , "fn_callback");
        */
        	this.fn_callback("svcLogin", 0, "");
        };

        this.fn_callback = function(svcId, errCd, errMsg)
        {
        	if(errCd < 0) {
        		this.alert("로그인 에러 : " + errMsg);
        		return;
        	};
        	if(svcId == "svcLogin"){
        		var objApp = nexacro.getApplication();
        		objApp.mainframe.VFrameSet00.set_separatesize("*,0"); //로그인되면 프레임 원래 사이즈로
        	};
        };


        this.div_login_edt_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) { // 엔터키 누르면
        		this.btn_login(); // 로그인 버튼 실행
        	}
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onsize",this.login_onsize,this);
            this.addEventHandler("onload",this.login_onload,this);
            this.div_login.form.edt_id.addEventHandler("oninput",this.Edit_oninput,this);
            this.div_login.form.edt_id.addEventHandler("onkeydown",this.div_login_edt_onkeydown,this);
            this.div_login.form.edt_pw.addEventHandler("oninput",this.Edit01_oninput,this);
            this.div_login.form.edt_pw.addEventHandler("onkeydown",this.div_login_edt_onkeydown,this);
            this.div_login.form.Button00.addEventHandler("onclick",this.btn_login,this);
            this.div_login.form.Static00.addEventHandler("onclick",this.Static00_onclick,this);
        };
        this.loadIncludeScript("login.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
