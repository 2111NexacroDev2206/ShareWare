(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_MemberList");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_member", this);
            obj._setContents("<ColumnInfo><Column id=\"memberNum\" type=\"STRING\" size=\"256\"/><Column id=\"memberName\" type=\"STRING\" size=\"256\"/><Column id=\"division\" type=\"STRING\" size=\"256\"/><Column id=\"rank\" type=\"STRING\" size=\"256\"/><Column id=\"address\" type=\"STRING\" size=\"256\"/><Column id=\"phone\" type=\"STRING\" size=\"256\"/><Column id=\"mail\" type=\"STRING\" size=\"256\"/><Column id=\"hireDate\" type=\"DATE\" size=\"256\"/><Column id=\"retireDate\" type=\"DATE\" size=\"256\"/><Column id=\"birth\" type=\"STRING\" size=\"256\"/><Column id=\"account\" type=\"STRING\" size=\"256\"/><Column id=\"bank\" type=\"STRING\" size=\"256\"/><Column id=\"password\" type=\"STRING\" size=\"256\"/><Column id=\"gender\" type=\"STRING\" size=\"256\"/><Column id=\"photo\" type=\"STRING\" size=\"256\"/><Column id=\"breakTotal\" type=\"FLOAT\" size=\"256\"/></ColumnInfo><Rows><Row/></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Grid("Grid00","60","140","1160","440",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_binddataset("ds_member");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"사진\"/><Cell col=\"1\" text=\"사원번호\"/><Cell col=\"2\" text=\"이름\"/><Cell col=\"3\" text=\"부서\"/><Cell col=\"4\" text=\"직급\"/><Cell col=\"5\" text=\"메일\"/><Cell col=\"6\" text=\"전화번호\"/></Band><Band id=\"body\"><Cell displaytype=\"imagecontrol\" text=\"expr:&quot;theme://images/A0.png&quot;\"/><Cell col=\"1\" text=\"bind:memberNum\"/><Cell col=\"2\" text=\"bind:memberName\"/><Cell col=\"3\" text=\"bind:division\"/><Cell col=\"4\" text=\"bind:rank\"/><Cell col=\"5\" text=\"bind:mail\"/><Cell col=\"6\" text=\"bind:phone\"/></Band></Format></Formats>");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","1100","75","120","50",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("사원 등록");
            this.addChild(obj.name, obj);

            obj = new Button("btn_all","60","90","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("전체");
            obj.set_background("RGBA(255,255,255,0)");
            obj.set_border("0px none");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("btn_exist","130","90","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("재직");
            obj.set_background("rgba(255,255,255,0)");
            obj.set_border("0px none");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Button("btn_noExist","200","90","50","45",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_text("퇴직");
            obj.set_background("rgba(255,255,255,0)");
            obj.set_border("0px none");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Combo("searchCondition","850","598","90","40",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var searchCondition_innerdataset = new nexacro.NormalDataset("searchCondition_innerdataset", obj);
            searchCondition_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">all</Col><Col id=\"datacolumn\">전체</Col></Row><Row><Col id=\"datacolumn\">이름</Col><Col id=\"codecolumn\">memberName</Col></Row><Row><Col id=\"datacolumn\">부서</Col><Col id=\"codecolumn\">division</Col></Row><Row><Col id=\"datacolumn\">직급</Col><Col id=\"codecolumn\">rank</Col></Row></Rows>");
            obj.set_innerdataset(searchCondition_innerdataset);
            obj.set_text("전체");
            obj.set_value("all");
            obj.set_index("0");
            this.addChild(obj.name, obj);

            obj = new Edit("searchValue","950","598","185","40",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            this.addChild(obj.name, obj);

            obj = new Button("btn_search","1145","598","75","40",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("검색");
            this.addChild(obj.name, obj);
            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

            
            // TriggerItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_MemberList.xfdl", function() {
        // 화면 실행 시 사원 리스트 불러오기
        this.Form_MemberList_onload = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=all" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.out_var = "";
        this.fn_callback_tran = function(id, nErrorCode, sErrorMsg)
        {
        	if(id=="member_list")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("사원 조회 실패 : " + sErrorMsg);
        			return;
        		}
        	}else if(id=="member_list_saerch")
        	{
        		if(nErrorCode < 0)
        		{
        			this.alert("사원 검색 실패 : " + sErrorMsg);
        			return;
        		}
        	}
        }

        // 재직 버튼 클릭
        this.btn_exist_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=exist" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        // 퇴직 버튼 클릭
        this.btn_noExist_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list" // 1. ID
        			, "SW::admin/member/list.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "inVar=noExist" // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        // 검색 버튼 클릭
        this.btn_search_onclick = function(obj,e)
        {
        	this.transaction(
        			"member_list_saerch" // 1. ID
        			, "SW::admin/member/searchList.sw" // 2. URL
        			, "" // 3. InDs : F->S jsp(I, U, D)
        			, "ds_member=out_member" // 4. OutDs : S->F jsp(SELECT) - 스페이스는 구분자라서 = 옆에 스페이스 없이 써야 함
        			, "searchCondition=" + this.searchCondition.value + " searchValue=" + this.searchValue.value // 5. InVar : F->S(var)
        			, "fn_callback_tran" // 6. callback function(transaction 완료 시 호출되는 함수)
        		);
        };

        this.searchValue_onkeydown = function(obj,e)
        {
        	if(e.keycode == 13) { // 엔터키 누르면
        		this.btn_search_onclick(); // 검색 버튼 실행
        	}
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_MemberList_onload,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.btn_all.addEventHandler("onclick",this.Form_MemberList_onload,this);
            this.btn_exist.addEventHandler("onclick",this.btn_exist_onclick,this);
            this.btn_noExist.addEventHandler("onclick",this.btn_noExist_onclick,this);
            this.searchValue.addEventHandler("onkeydown",this.searchValue_onkeydown,this);
            this.btn_search.addEventHandler("onclick",this.btn_search_onclick,this);
        };
        this.loadIncludeScript("Form_MemberList.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
