(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectListCT', ProjectListCT);

	ProjectListCT.$inject = [ '$scope', '$log', '$mdDialog', 'HttpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $mdDialog
	 * @param HttpSV
	 * @returns
	 */
	function ProjectListCT($scope, $log, $mdDialog, HttpSV) {
		$log.debug('[ProjectListCT] Inicializando...');
		var self = this;

		self.projects = [];

		init();
		
		function init() {
			HttpSV.get('/projects').then(function(data){
				self.projects = data;
			});
		}
		
	}
})();