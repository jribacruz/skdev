(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionEditorCT', ActionEditorCT);

	ActionEditorCT.$inject = [ '$scope', '$log', '$mdDialog' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ActionEditorCT($scope, $log, $mdDialog) {
		$log.debug('[ActionEditorCT] Inicializando...');
		var self = this;

		var editors = {};
		
		self.runDialog = runDialog;

		init();

		function init() {
			$log.debug('[ActionEditorCT] Inicializando editor execute.js')
			angular.element(document).ready(function() {
				/*
				 * Inicializando o editor de dialog.
				 */
				editors['dialog'] = CodeMirror(document.getElementById('dialogEditor'), {
					mode : "htmlmixed",
					lineNumbers : true,
					autoCloseTags : true,
					theme : 'eclipse'
				});
				editors['dialog'].setSize('100%', '100%');
				
				/*
				 * Inicializando o editor de action execute
				 */
				editors['execute'] = CodeMirror(document.getElementById('executeEditor'), {
					value : "$notification.show('Funcionou')",
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
					indentUnit : 4
				});
				editors['execute'].setSize('100%', '100%');

			});
		}
		
		function runDialog() {
			console.log(editors['dialog'].getValue());
			$mdDialog.show({
				parent : angular.element(document.body),
				template : editors['dialog'].getValue(),
				clickOutsideToClose : false,
				controller : 'ActionCT'
			});
		}
	}
})();
