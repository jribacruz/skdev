(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$mdSidenav', '$location', 'actionSV', '$mdDialog', 'notificationSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdSidenav
	 * @param $location
	 * @returns
	 */
	function ActionEditorCT($scope, $log, $mdSidenav, $location, actionSV, $mdDialog, notificationSV) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};
		
		self.loading = true;

		self.action = {};

		self.save = save;
		
		self.hideActionInfo = hideActionInfo;
		
		self.sidenavRight = sidenavRight;
		
		self.saveStatus = false;
		
		self.runAction = runAction;
		
		init();

		function init() {
			angular.element(document).ready(function() {
				_initExecuteJSEditor();
				_initDialogHTMLEditor();
				_loadOrCreateAction();
			});
		}

		/*
		 * Inicializa o editor de action execute
		 */
		function _initExecuteJSEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor executeJS...')
			editors['executeJS'] = CodeMirror(document.getElementById('executeJSEditor'), {
				mode : "javascript",
				lineNumbers : true,
				gutters : [ "CodeMirror-lint-markers" ],
				lint : true,
				autoCloseBrackets : true,
				extraKeys : {
					"Ctrl-Space" : "autocomplete"
				},
				matchBrackets : false,
				theme : 'eclipse',
				indentUnit : 4,
				styleActiveLine : true
			});
			editors['executeJS'].setSize('100%', '100%');
		}

		function _initDialogHTMLEditor() {
			$log.debug('[ActionEditorCT] Inicializando editor dialogHTML...');
			editors['dialogHTML'] = CodeMirror(document.getElementById('dialogHTMLEditor'), {
				mode : "htmlmixed",
				lineNumbers : true,
				autoCloseTags : true,
				gutters : [ "CodeMirror-lint-markers" ],
				theme : 'eclipse',
				indentUnit : 4,
				styleActiveLine : true
			});
			editors['dialogHTML'].setSize('100%', '100%');
		}

		function _loadOrCreateAction() {
			var id = URI($location.absUrl()).filename();
			if (!isNaN(id)) {
				actionSV.load(id).then(function(res) {
					self.action = res.data;
					editors['dialogHTML'].setValue(res.data.dialogHTML);
					editors['executeJS'].setValue(res.data.executeJS);
					self.loading = false;
				});
				return;
			}
			self.action = actionSV.newAction();
			_showActionInfo();
			self.loading= false;
		}

		function _showActionInfo() {
			$mdDialog.show({
				parent : angular.element(document.body),
				contentElement : '#actionInfoDialog',
				clickOutsideToClose : false
			});
		}
		
		function save() {
			self.saveStatus = true;
			if(self.action.id == 0) {
				$log.debug('[ActionEditorCT] save/insert');
				actionSV.insert(self.action).then(function(res) {
					$mdDialog.hide();
					self.saveStatus = false;
					self.action = res.data;
					notificationSV.show('Ação salva com sucesso.');
				});
				return;
			}
			$log.debug('[ActionEditorCT] save/update');
			self.action.dialogHTML = editors['dialogHTML'].getValue();
			self.action.executeJS = editors['executeJS'].getValue();
			actionSV.update(self.action).then(function(res) {
				notificationSV.show('Ação atualizado com sucesso.');
				self.saveStatus = false;
			});
		}
			
		function hideActionInfo() {
			self.loading= false;
			$mdDialog.hide();
		}
		
		function sidenavRight() {
			$mdSidenav('sidenav-right').toggle();
		}
		
		function runAction(eAction) {
			self.action.dialogHTML = editors['dialogHTML'].getValue();
			self.action.executeJS = editors['executeJS'].getValue();
			actionSV.run(eAction);
		}
		
	}
})();
