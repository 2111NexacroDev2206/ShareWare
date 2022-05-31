(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Leave");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_leave", this);
            obj._setContents("<ColumnInfo><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" type=\"STRING\" size=\"256\"/><Column id=\"leaveTotal\" type=\"STRING\" size=\"256\"/><Column id=\"leaveUse\" type=\"STRING\" size=\"256\"/><Column id=\"leaveRemain\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","156","1160","454",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("ds_leave");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"100\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"35\" band=\"head\"/><Row size=\"35\"/></Rows><Band id=\"head\"><Cell text=\"이름\"/><Cell col=\"1\" text=\"입사일\"/><Cell col=\"2\" text=\"총연차\"/><Cell col=\"3\" text=\"사용연차\"/><Cell col=\"4\" text=\"잔여연차\"/></Band><Band id=\"body\"><Cell text=\"bind:memberName\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:hireDate\" displaytype=\"mask\" maskeditformat=\"####-##-##\" maskedittype=\"string\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:leaveTotal\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:leaveUse\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:leaveRemain\" textAlign=\"center\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Combo("searchCondition","850","640","90","40",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var searchCondition_innerdataset = new nexacro.NormalDataset("searchCondition_innerdataset", obj);
            searchCondition_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">all</Col><Col id=\"datacolumn\">전체</Col></Row><Row><Col id=\"datacolumn\">이름</Col><Col id=\"codecolumn\">memberName</Col></Row><Row><Col id=\"datacolumn\">부서</Col><Col id=\"codecolumn\">division</Col></Row></Rows>");
            obj.set_innerdataset(searchCondition_innerdataset);
            obj.set_text("전체");
            obj.set_value("all");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","950","640","185","40",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","1145","640","75","40",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("검색");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Button("year_btn","211","111","52","29",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("조회");
            obj.set_cssclass("notRadius");
            this.addChild(obj.name, obj);

            obj = new Calendar("year","60","111","133","29",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_dateformat("yyyy");
            obj.set_editformat("yyyy");
            obj.set_usesoftkeyboard("true");
            obj.set_headformat("yyyy");
            obj.set_type("spin");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","60","30","120","60",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("연차 관리");
            obj.set_font("normal 700 17pt/normal \"Arial\"");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Leave.xfdl", function() {
        //조회
        this.Leave_onload = function(obj,e)
        {
        	var objDate = new nexacro.Date();
        	var today = objDate.getYear();
        	this.year.set_value(today);
        	this.transaction(
        		"leave_list"// 1.ID
        		,"SW::admin/leave/leaveList.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_leave = out_leave" // 4.OutDs : S->F jsp(SELECT)
        		,"year=" + this.year.getYear() // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);
        };

        this.out_var = "";
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id == "leave_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id=="leave_list_search")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("연차 검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id == "leaveYear_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("연도 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        }

        // 검색
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"leave_list_search" // 1. ID
        			, "SW::admin/leave/leaveSearchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_leave=out_leave" // 4. OutDs : S->F jsp(SELECT)
        			, "year=" + this.year.getYear() + " searchCondition=" + this.searchCondition.value + " searchValue=" + nexacro.wrapQuote(this.searchValue.value) // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };
        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) {
        		this.btn_search_onclick();
        	}
        };

        //년도 조회
        this.year_btn_onclick = function(obj,e)
        {
        	this.transaction(
        		"leaveYear_list"// 1.ID
        		,"SW::admin/leave/leaveList.sw"// 2.URL
        		,""// 3.InDs : F->S jsp(I,U,D)
        		,"ds_leave=out_leave" // 4.OutDs : S->F jsp(SELECT)
        		,"year=" + this.year.getYear()  // 5.InVar : F->S(var)
        		,"fn_callback_tran" // 6.callback function(transaction 완료시 호출되는 함수)
        	);
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Leave_onload,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
            this.year_btn.addEventHandler("onclick",this.year_btn_onclick,this);
        };
        this.loadIncludeScript("Leave.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
