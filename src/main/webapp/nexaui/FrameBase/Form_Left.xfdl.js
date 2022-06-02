(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Left");
            this.set_titletext("Form_Left");
            this.set_border("none");
            if (Form == this.constructor)
            {
                this._setFormPosition(1500,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Div("menu","0","0","220",null,null,"0",null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_background("#5a86cd");
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","22","22","136","58",null,null,null,null,null,null,this.menu.form);
            obj.set_taborder("0");
            obj.set_text("Share");
            obj.set_color("white");
            obj.set_font("40pt/normal \"Changa\"");
            obj.set_textAlign("center");
            obj.set_fittocontents("both");
            this.menu.addChild(obj.name, obj);

            obj = new Static("Static00_00","75","71","130","58",null,null,null,null,null,null,this.menu.form);
            obj.set_taborder("1");
            obj.set_text("Ware");
            obj.set_color("white");
            obj.set_font("40pt/normal \"Changa\"");
            obj.set_textAlign("center");
            obj.set_fittocontents("both");
            this.menu.addChild(obj.name, obj);

            obj = new Button("btn_mem","25","163","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("사원관리");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_leave","25","236","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("연차관리");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_att","25","309","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("근태현황");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_org","25","382","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("조직도");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_notice","25","455","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("공지 게시판");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_meetingRoom","25","528","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_text("회의실 예약 현황");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Button("btn_mail","25","601","170","60",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("승인 메일 관리");
            obj.set_cssclass("menu");
            obj.set_textAlign("left");
            obj.set_padding("0px 0px 0px 15px");
            this.addChild(obj.name, obj);

            obj = new Div("mainDiv","220","0",null,null,"0","0",null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_url("FrameBase::Form_MemberList.xfdl");
            obj.set_text("");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1500,720,this,
            	//-- Layout function
            	function(p)
            	{
                var rootobj = p;


                // {{ this.menu
                p = rootobj.menu.form;

                p.Static00.set_taborder("0");
                p.Static00.set_text("Share");
                p.Static00.set_color("white");
                p.Static00.set_font("40pt/normal \"Changa\"");
                p.Static00.set_textAlign("center");
                p.Static00.set_fittocontents("both");
                p.Static00.move("22","22","136","58",null,null);

                p.Static00_00.set_taborder("1");
                p.Static00_00.set_text("Ware");
                p.Static00_00.set_color("white");
                p.Static00_00.set_font("40pt/normal \"Changa\"");
                p.Static00_00.set_textAlign("center");
                p.Static00_00.set_fittocontents("both");
                p.Static00_00.move("75","71","130","58",null,null);
                // this.menu }}
                p = rootobj;
                p.set_titletext("Form_Left");
                p.set_border("none");

                p.menu.set_taborder("8");
                p.menu.set_background("#5a86cd");
                p.menu.set_text("");
                p.menu.move("0","0","220",null,null,"0");

                p.btn_mem.set_taborder("0");
                p.btn_mem.set_text("사원관리");
                p.btn_mem.set_cssclass("menu");
                p.btn_mem.set_textAlign("left");
                p.btn_mem.set_padding("0px 0px 0px 15px");
                p.btn_mem.move("25","163","170","60",null,null);

                p.btn_leave.set_taborder("1");
                p.btn_leave.set_text("연차관리");
                p.btn_leave.set_cssclass("menu");
                p.btn_leave.set_textAlign("left");
                p.btn_leave.set_padding("0px 0px 0px 15px");
                p.btn_leave.move("25","236","170","60",null,null);

                p.btn_att.set_taborder("2");
                p.btn_att.set_text("근태현황");
                p.btn_att.set_cssclass("menu");
                p.btn_att.set_textAlign("left");
                p.btn_att.set_padding("0px 0px 0px 15px");
                p.btn_att.move("25","309","170","60",null,null);

                p.btn_org.set_taborder("3");
                p.btn_org.set_text("조직도");
                p.btn_org.set_cssclass("menu");
                p.btn_org.set_textAlign("left");
                p.btn_org.set_padding("0px 0px 0px 15px");
                p.btn_org.move("25","382","170","60",null,null);

                p.btn_notice.set_taborder("4");
                p.btn_notice.set_text("공지 게시판");
                p.btn_notice.set_cssclass("menu");
                p.btn_notice.set_textAlign("left");
                p.btn_notice.set_padding("0px 0px 0px 15px");
                p.btn_notice.move("25","455","170","60",null,null);

                p.btn_meetingRoom.set_taborder("5");
                p.btn_meetingRoom.set_text("회의실 예약 현황");
                p.btn_meetingRoom.set_cssclass("menu");
                p.btn_meetingRoom.set_textAlign("left");
                p.btn_meetingRoom.set_padding("0px 0px 0px 15px");
                p.btn_meetingRoom.move("25","528","170","60",null,null);

                p.btn_mail.set_taborder("6");
                p.btn_mail.set_text("승인 메일 관리");
                p.btn_mail.set_cssclass("menu");
                p.btn_mail.set_textAlign("left");
                p.btn_mail.set_padding("0px 0px 0px 15px");
                p.btn_mail.move("25","601","170","60",null,null);

                p.mainDiv.set_taborder("7");
                p.mainDiv.set_url("FrameBase::Form_MemberList.xfdl");
                p.mainDiv.set_text("");
                p.mainDiv.move("220","0",null,null,"0","0");
            	}
            );
            this.addLayout(obj.name, obj);

            //-- Normal Layout : this
            obj = new Layout("Layout0","",1400,720,this,
            	//-- Layout function
            	function(p)
            	{
                var rootobj = p;
                p = rootobj;

            	}
            );
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {
            this._addPreloadList("fdl","FrameBase::Form_MemberList.xfdl");
        };
        
        // User Script
        this.registerScript("Form_Left.xfdl", function() {
        /*+++++++++++++++++++++++++++++++++++++++++++++++++
         |  		페이지 로드시 초기 Setting
         ++++++++++++++++++++++++++++++++++++++++++++++++++*/
        this.fn_FormLoadSetting = function (obj, e)
        {

        };

        /*+++++++++++++++++++++++++++++++++++++++++++++++++
         |  		페이지 이동
         ++++++++++++++++++++++++++++++++++++++++++++++++++*/
         //홈
        this.btn_home_onclick = function(obj,e)
        {
        	//메인 이동
        	//this.mainDiv.set_url("FrameBase::main.xfdl");
        	this.mainDiv.set_url("FrameBase::main.xfdl");
        };

        //인사관리
        this.btn_mem_onclick = function(obj,e)
        {
        	//사원관리 이동
        	this.mainDiv.set_url("FrameBase::Form_MemberList.xfdl");
        };

        this.btn_leave_onclick = function(obj,e)
        {
        	//연차관리 이동
        	this.mainDiv.set_url("FrameBase::Leave.xfdl");
        };

        //근태관리
        this.btn_att_onclick = function(obj,e)
        {
        	//근태관리 이동
        	this.mainDiv.set_url("FrameBase::Attendance.xfdl");
        };

        //조직도
        this.btn_org_onclick = function(obj,e)
        {
        	//조직도 이동
        	this.mainDiv.set_url("FrameBase::organization.xfdl");
        };

        // 공지 게시판
        this.btn_notice_onclick = function(obj,e)
        {
        	this.mainDiv.set_url("FrameBase::noticeList.xfdl");
        };
        // 회의실 예약 현황
        this.btn_meetingRoom_onclick = function(obj,e)
        {
        	this.mainDiv.set_url("FrameBase::meetingRoom.xfdl");
        };

        this.btn_mail_onclick = function(obj,e)
        {
        	this.mainDiv.set_url("FrameBase::mail.xfdl");
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.fn_FormLoadSetting,this);
            this.menu.form.Static00.addEventHandler("onclick",this.Static00_onclick,this);
            this.menu.form.Static00_00.addEventHandler("onclick",this.Static00_onclick,this);
            this.btn_mem.addEventHandler("onclick",this.btn_mem_onclick,this);
            this.btn_leave.addEventHandler("onclick",this.btn_leave_onclick,this);
            this.btn_att.addEventHandler("onclick",this.btn_att_onclick,this);
            this.btn_org.addEventHandler("onclick",this.btn_org_onclick,this);
            this.btn_notice.addEventHandler("onclick",this.btn_notice_onclick,this);
            this.btn_meetingRoom.addEventHandler("onclick",this.btn_meetingRoom_onclick,this);
            this.btn_mail.addEventHandler("onclick",this.btn_mail_onclick,this);
        };
        this.loadIncludeScript("Form_Left.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
