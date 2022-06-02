(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Attendance");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_att", this);
            obj._setContents("<ColumnInfo><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"division\" type=\"STRING\" size=\"256\"/><Column id=\"attDate\" type=\"STRING\" size=\"256\"/><Column id=\"attStrTime\" type=\"STRING\" size=\"256\"/><Column id=\"attFinTime\" type=\"STRING\" size=\"256\"/><Column id=\"attTotalTime\" type=\"STRING\" size=\"256\"/><Column id=\"attStatus\" type=\"STRING\" size=\"256\"/><Column id=\"memNum\" type=\"STRING\" size=\"256\"/><Column id=\"lateNum\" type=\"INT\" size=\"256\"/><Column id=\"attNum\" type=\"STRING\" size=\"256\"/><Column id=\"absNum\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_stats", this);
            obj._setContents("<ColumnInfo><Column id=\"lateNum\" type=\"INT\" size=\"256\"/><Column id=\"attNum\" type=\"INT\" size=\"256\"/><Column id=\"absNum\" type=\"INT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static01_00_00_00","60","165","293","38",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_background("#ffffff");
            obj.set_border("1px solid #d5d5d5");
            obj.set_color("#000000");
            obj.set_padding("2px");
            this.addChild(obj.name, obj);

            obj = new Static("Static14_00_00_00_00","61","166","82","36",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("     검색일");
            obj.set_background("#f5f5f5");
            obj.set_padding("");
            obj.set_cssclass("sta_WF_detailLabel");
            this.addChild(obj.name, obj);

            obj = new Calendar("date","150","172","186","24",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("btn_date","363","165","60","38",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid_att","60","227","1160","433",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_binddataset("ds_att");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"35\" band=\"head\"/><Row size=\"35\"/></Rows><Band id=\"head\"><Cell text=\"이름\"/><Cell col=\"1\" text=\"부서\"/><Cell col=\"2\" text=\"날짜\"/><Cell col=\"3\" text=\"출근시간\"/><Cell col=\"4\" text=\"퇴근시간\"/><Cell col=\"5\" text=\"근무시간\"/><Cell col=\"6\" text=\"근무상태\"/></Band><Band id=\"body\"><Cell text=\"bind:memberName\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:division\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:attDate\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:attStrTime\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:attFinTime\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:attTotalTime\" textAlign=\"center\"/><Cell col=\"6\" text=\"bind:attStatus\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Grid("Grid01","574","104","646","102",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_binddataset("ds_stats");
            obj.set_autofittype("col");
            obj.set_autosizebandtype("body");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"50\" band=\"head\"/><Row size=\"50\"/></Rows><Band id=\"head\"><Cell text=\"지각\"/><Cell col=\"1\" text=\"출근\"/><Cell col=\"2\" text=\"결근\"/></Band><Band id=\"body\"><Cell text=\"bind:lateNum\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:attNum\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:absNum\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Combo("searchCondition","61","116","82","38",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var searchCondition_innerdataset = new nexacro.NormalDataset("searchCondition_innerdataset", obj);
            searchCondition_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">all</Col><Col id=\"datacolumn\">전체</Col></Row><Row><Col id=\"datacolumn\">이름</Col><Col id=\"codecolumn\">memberName</Col></Row><Row><Col id=\"datacolumn\">부서</Col><Col id=\"codecolumn\">division</Col></Row></Rows>");
            obj.set_innerdataset(searchCondition_innerdataset);
            obj.set_text("전체");
            obj.set_value("all");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","161","116","190","38",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","363","116","60","38",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("근태 현황");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","date","value","ds_emp","HIRE_DATE");
            this.addChild(obj.name, obj);
            obj.bind();
            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Attendance.xfdl", function() {
        //조회
        this.Attendance_onload = function(obj,e)
        {
        	var currDate = new Date();
            var year = currDate.getFullYear().toString().padLeft(4, "0");
            var month = (currDate.getMonth()+1).toString().padLeft(2, "0");
            var day = currDate.getDate().toString().padLeft(2, "0");
            this.date.set_value(year+month+day);

        	//리스트
        	this.transaction(
        		"att_list"// 1.ID
        		,"SW::admin/attendance/attList.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_att=out_att" // 4.OutDs : S->F jsp(SELECT)
        		,"inVar=" + this.date.getYear().toString().padLeft(4, "0") + this.date.getMonth().toString().padLeft(2, "0") + this.date.getDay().toString().padLeft(2, "0") // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);

        	//통계
        	this.transaction(
        		"att_stats"// 1.ID
        		,"SW::admin/attendance/attStats.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_stats=out_attSts" // 4.OutDs : S->F jsp(SELECT)
        		,"inVar=" + this.date.getYear().toString().padLeft(4, "0") + this.date.getMonth().toString().padLeft(2, "0") + this.date.getDay().toString().padLeft(2, "0") // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);

        };


        // 검색
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"att_list_saerch" // 1. ID
        			, "SW::admin/attendance/searchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_att=out_att" // 4. OutDs : S->F jsp(SELECT)
        			, "inVar=" + this.date.getYear().toString().padLeft(4, "0") + this.date.getMonth().toString().padLeft(2, "0") + this.date.getDay().toString().padLeft(2, "0")+
        						" searchCondition=" + this.searchCondition.value + " searchValue=" + nexacro.wrapQuote(this.searchValue.value) // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) {
        		this.btn_search_onclick();
        	}
        };

        //날짜검색
        this.btn_date_onclick = function(obj,e)
        {
        	this.transaction(
        		"att_date_search"// 1.ID
        		,"SW::admin/attendance/attList.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_att=out_att" // 4.OutDs : S->F jsp(SELECT)
        		,"inVar=" + this.date.getYear().toString().padLeft(4, "0") + this.date.getMonth().toString().padLeft(2, "0") + this.date.getDay().toString().padLeft(2, "0") // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);

        	//통계
        	this.transaction(
        		"att_stats"// 1.ID
        		,"SW::admin/attendance/attStats.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_stats=out_attSts" // 4.OutDs : S->F jsp(SELECT)
        		,"inVar=" + this.date.getYear().toString().padLeft(4, "0") + this.date.getMonth().toString().padLeft(2, "0") + this.date.getDay().toString().padLeft(2, "0") // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);
        };

        //콜백
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg, sSuccessMsg)
        {
        	//
        		//alert("리스트 : "+this.ds_att.getCount());
        		//alert("통계 : "+this.ds_stats.getCount());
        		//alert(this.ds_att.getColumn(0,"lateNum"));
        	//

        	if(id == "att_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id=="att_list_saerch")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id == "att_date_search")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("날짜 검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id == "att_stats")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("통계 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}


        }
        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Attendance_onload,this);
            this.Static14_00_00_00_00.addEventHandler("onclick",this.div_detail_Static14_onclick,this);
            this.date.addEventHandler("onchanged",this.cal_date_onchanged,this);
            this.btn_date.addEventHandler("onclick",this.btn_date_onclick,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
        };
        this.loadIncludeScript("Attendance.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
